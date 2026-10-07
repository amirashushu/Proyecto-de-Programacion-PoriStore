package hostCliente;
import entidades.Categorias;
import entidades.Inventario;
import entidades.Producto;
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class HostCliente {
    private static final String HOST = "192.168.1.8";
    private static final int PORT = 65432;
    private static PrintWriter serverOut;
    private static vistas.VistaPrincipal vistaPrincipalActiva;
    
    public static void setVistaPrincipal(vistas.VistaPrincipal vista) {
        vistaPrincipalActiva = vista;
    }
    
    public void initHost(Inventario inv){
        while (true) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(HOST, PORT));
                System.out.println("[+] Conectado exitosamente al servidor.");
                handleConnection(socket, inv);
            } catch (ConnectException e) {
                System.err.println("[!] Servidor no disponible en " + HOST + ":" + PORT + ". Reintentando en 3 segundos...");
            } catch (IOException e) {
                System.err.println("Error en el cliente: " + e.getMessage() + ". Reintentando en 3 segundos...");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                break;
            }
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
                            if (p != null) {
                                p.setStock(cantidad);
                                System.out.println("[Cliente] Stock actualizado para producto ID " + id + ": " + cantidad);
                            }
                            
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
                                invent.actualizarProductoCliente(nombre, descripcion, precio, stock, Categorias.valueOf(categoria), id, rutaImagen);
                                System.out.println("[Cliente] Producto actualizado: " + nombre + " (ID " + id + ")");
                            }else{
                                invent.reCrearProducto(id, nombre, descripcion, precio, stock, Categorias.valueOf(categoria), rutaImagen);
                                System.out.println("[Cliente] Producto agregado al inventario: " + nombre + " (ID " + id + ")");
                            }    
                        }else if ("eliminar".equals(type)){
                            String idStr = extractJsonField(line, "id");
                            int id = Integer.parseInt(idStr.trim());
                            invent.eliminarProducto(id);
                            System.out.println("[Cliente] Producto eliminado (ID " + id + ")");
                        }

                        // Refrescar automáticamente la pantalla del catálogo si la vista está abierta
                        if (vistaPrincipalActiva != null) {
                            java.awt.EventQueue.invokeLater(() -> {
                                vistaPrincipalActiva.cargarCatalogoProductos();
                            });
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
