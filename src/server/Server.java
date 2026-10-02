package server;

import entidades.Inventario;
import entidades.Producto;
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class Server {

    private static final String HOST = "172.16.52.155";
    private static final int PORT = 65432;

    public boolean initServer(Inventario invent) {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(HOST, PORT));
            System.out.println("Servidor Java escuchando en " + HOST + ":" + PORT + " ...");
            System.out.println("Esperando conexiones de clientes...");

            // Un hilo por cliente: el accept() se repite para siempre
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(() -> handleClient(clientSocket, invent));
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            return false;
        }
    }

    private static void handleClient(Socket clientSocket, Inventario invent) {
        System.out.println("[+] Conectado por " + clientSocket.getInetAddress());

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true)) {

            String line;
            while ((line = in.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String type = extractJsonField(line, "type");

                if ("data_exchange".equals(type)) {
                    String cantidadStr = extractJsonField(line, "numero");
                    String idStr = extractJsonField(line, "texto");

                    if (cantidadStr == null || idStr == null) {
                        out.println(createJsonMessage("Solicitud incompleta: faltan campos."));
                        continue;
                    }

                    try {
                        int cantidad = Integer.parseInt(cantidadStr.trim());
                        int id = Integer.parseInt(idStr.trim());

                        if (cantidad <= 0) {
                            out.println(createJsonMessage("La cantidad debe ser mayor a 0."));
                            continue;
                        }

                        int stockActual;

                        // Buscar, validar, actualizar y leer el stock como una sola operación atómica
                        synchronized (invent) {
                            Producto p = invent.buscarPorId(id);

                            if (p == null) {
                                out.println(createJsonMessage("Producto no encontrado: " + id));
                                continue;
                            }
                            if (cantidad > p.getStock()) {
                                out.println(createJsonMessage("Stock insuficiente para el producto " + id));
                                continue;
                            }

                            invent.actualizarInventario(p, -cantidad);
                            stockActual = p.getStock();
                        }

                        out.println(createJsonData(stockActual, String.valueOf(id)));

                    } catch (NumberFormatException e) {
                        out.println(createJsonMessage("La cantidad y el id deben ser enteros válidos."));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("[-] Conexión con el cliente interrumpida: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("[-] El cliente se ha desconectado.");
        }
    }

    // Método para crear JSON de mensaje simple
    private static String createJsonMessage(String content) {
        return "{\"type\": \"message\", \"content\": \"" + escapeJson(content) + "\"}";
    }

    // Método para crear JSON de intercambio de datos
    private static String createJsonData(int numero, String texto) {
        return "{\"type\": \"data_exchange\", \"numero\": " + numero + ", \"texto\": \"" + escapeJson(texto) + "\"}";
    }

    // Método para escapar caracteres especiales en JSON
    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }

    // Método simple para extraer campos de JSON (sin librerías externas)
    private static String extractJsonField(String json, String fieldName) {
        // Para campos de texto (string)
        Pattern stringPattern = Pattern.compile("\"" + fieldName + "\"\\s*:\\s*\"([^\"]*)\"");
        Matcher stringMatcher = stringPattern.matcher(json);
        if (stringMatcher.find()) {
            return unescapeJson(stringMatcher.group(1));
        }

        // Para campos numéricos
        Pattern numberPattern = Pattern.compile("\"" + fieldName + "\"\\s*:\\s*(-?\\d+)");
        Matcher numberMatcher = numberPattern.matcher(json);
        if (numberMatcher.find()) {
            return numberMatcher.group(1);
        }

        return null;
    }

    // Método para desescapar caracteres JSON
    private static String unescapeJson(String text) {
        return text.replace("\\\"", "\"")
                   .replace("\\\\", "\\")
                   .replace("\\n", "\n")
                   .replace("\\r", "\r")
                   .replace("\\t", "\t");
    }
}