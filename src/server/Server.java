package server;
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class Server {
    
    private static final String HOST = "172.16.52.155";
    private static final int PORT = 65432;
    
    public void initServer(){
    try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(HOST, PORT));
            System.out.println("Servidor Java escuchando en " + HOST + ":" + PORT + " ...");  
            System.out.println("Esperando conexión de un cliente...");

            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
    private static void handleClient(Socket clientSocket) {
       
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true)) {

            // Hilo para recibir mensajes
            Thread receiveThread = new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.trim().isEmpty()) continue;

                        String type = extractJsonField(line, "type");
                        
                        if ("data_exchange".equals(type)) {
                            String numero = extractJsonField(line, "numero");
                            String texto = extractJsonField(line, "texto");

                        } else if ("message".equals(type)) {
                            String content = extractJsonField(line, "content");
                            System.out.println("\n[Cliente]: " + content);
                            System.out.print("Tu mensaje: ");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("\n[-] El cliente se ha desconectado.");
                } finally {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();

            // Bucle principal para enviar mensajes
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            
            while ((msg = consoleReader.readLine()) != null) {
                if (msg.equalsIgnoreCase("salir") || msg.equalsIgnoreCase("exit") || msg.equalsIgnoreCase("quit")) {
                    System.out.println("Cerrando conexión...");
                    break;
                }

                if (msg.toLowerCase().startsWith("datos:")) {
                    try {
                        String contenido = msg.substring(6).trim();
                        int commaIndex = contenido.indexOf(',');
                        
                        if (commaIndex > 0) {
                            String numeroStr = contenido.substring(0, commaIndex).trim();
                            String texto = contenido.substring(commaIndex + 1).trim();
                            int numero = Integer.parseInt(numeroStr);

                            String json = createJsonData(numero, texto);
                            System.out.println("[Servidor envía] Número: " + numero + ", Texto: '" + texto + "'");
                            out.println(json);
                        } else {
                            System.out.println("[!] Formato incorrecto. Usa: datos:numero,texto");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("[!] Error: El número debe ser un entero válido.");
                    }
                } else {
                    String json = createJsonMessage(msg);
                    out.println(json);
                }
            }

        } catch (IOException e) {
            System.err.println("Error manejando cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

