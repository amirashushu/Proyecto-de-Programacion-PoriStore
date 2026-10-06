package hostCliente;
import entidades.Categorias;
import entidades.Inventario;
import entidades.Producto;
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class HostCliente {
    private static final String HOST = "172.26.64.110";
    private static final int PORT = 65432;
    private static PrintWriter serverOut;
    
    public void initHost(Inventario inv){
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(HOST, PORT));
            handleConnection(socket, inv);

        } catch (ConnectException e) {
            System.err.println("[!] Error: No se pudo conectar al servidor. ¿Está encendido?");
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
    private static void handleConnection(Socket socket, Inventario invent) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true)) {
            serverOut = out; 
            // Hilo para recibir mensajes
            Thread receiveThread = new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.trim().isEmpty()) continue;

                        String type = extractJsonField(line, "type");
                        
                        if ("data_exchange".equals(type)) {
                            String cantidadStr = extractJsonField(line, "numero");
                            String idStr = extractJsonField(line, "texto");
                            
                            int cantidad = Integer.parseInt(cantidadStr.trim());
                            int id = Integer.parseInt(idStr.trim());
                            Producto p = invent.buscarPorId(id);
                            p.setStock(cantidad);
                            
                        } else if ("message".equals(type)) {
                            String content = extractJsonField(line, "content");
                            System.out.println("\n[Servidor]: " + content);
                            System.out.print("Tu mensaje: ");
                            
                        }else if ("get_producto".equals(type)){
                            String idStr = extractJsonField(line, "id");
                            String nombre = extractJsonField(line, "nombre");
                            String descripcion = extractJsonField(line, "descripcion");
                            String precioStr = extractJsonField(line, "precio");
                            String categoria = extractJsonField(line, "categoria");
                            String stockStr = extractJsonField(line, "stock");
                            String rutaImagen = extractJsonField(line, "rutaImagen");
                            
                            int id = Integer.parseInt(idStr.trim());
                            double precio = Double.parseDouble(precioStr.trim());
                            int stock =  Integer.parseInt(stockStr.trim());
                            boolean existia=false;
                            for (Producto p : invent.getProductos()){
                                if (p.getId() == id){
                                    existia = true;
                                    break;
                                }
                            }
                            if (existia){
                                invent.actualizarProducto(nombre, descripcion, precio, stock, Categorias.valueOf(categoria), id);
                            }else{
                                invent.reCrearProducto(id, nombre, descripcion, precio, stock, Categorias.valueOf(categoria), rutaImagen);
                            }    
                        }else if ("eliminar".equals(type)){
                            String idStr = extractJsonField(line, "id");
                            int id = Integer.parseInt(idStr.trim());
                            invent.eliminarProducto(id);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("\n[-] Desconectado del servidor.");
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();
            receiveThread.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void notificarPeticion (int id, int cant){
        broadcast(createJsonData(cant, String.valueOf(id)));
    }
    private static void broadcast(String mensajeJson) {        
        if (serverOut != null) {
            serverOut.println(mensajeJson); // Envía el mensaje al servidor
            serverOut.flush();
        } else {
            System.err.println("[!] Error: No hay conexión activa con el servidor.");
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
