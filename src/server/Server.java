package server;

import entidades.ApiGemini;
import entidades.Inventario;
import entidades.Producto;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.*;
import logica.SistemaTienda;

public class Server {

    private static final String HOST = "192.168.1.11";
    private static final int PORT = 65432;
    private static final Set<PrintWriter> clientesConectados = new CopyOnWriteArraySet<>();
    private static final HashMap<PrintWriter, StringBuilder> historialCliente= new HashMap<>();
    private static final java.util.Map<String, PrintWriter> clientePorCarrito = new java.util.concurrent.ConcurrentHashMap<>();
    private static vistas.Dashboard dashboardTabla;

    
    public static void setDashboard(vistas.Dashboard d) {
        dashboardTabla = d;
    }   

    // Sistema del admin, donde se guardan los carritos que mandan los clientes
    private static logica.SistemaTienda sistemaAdmin;

    public static void setSistema(logica.SistemaTienda st) {
        sistemaAdmin = st;
    }
    
    public boolean initServer(SistemaTienda st) {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(HOST, PORT));
            System.out.println("Esperando conexiones de clientes...");

            // Un hilo por cliente: el accept() se repite para siempre
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(() -> handleClient(clientSocket, st));
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            return false;
        }
    }

    private static void handleClient(Socket clientSocket, SistemaTienda st) {
        System.out.println("[+] Conectado por " + clientSocket.getInetAddress());
        PrintWriter out = null;
        Inventario invent = st.getInventario();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
            PrintWriter temp = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true)) {
            out = temp;
            StringBuilder sb = new StringBuilder();
            historialCliente.put(out, sb);
            clientesConectados.add(out);

            //sincronizar al cliente enviándole los productos existentes en el servidor
            synchronized (invent) {
                for (Producto p : invent.getProductos()) {
                    out.println(createJsonProducto(p));
                }
            }

            String line;
            
            while ((line = in.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String type = extractJsonField(line, "type");

                //Un cliente avisa como quedo su carrito, el admin lo muestra en "Carritos activos" y en "Reservado"
                if ("carrito".equals(type)) {
                    String idCarrito = extractJsonField(line, "id");
                    if (idCarrito != null) {
                        clientePorCarrito.put(idCarrito, out); //se guarda el dueño del carrito
                    }
                    if (sistemaAdmin != null) {
                        // Extraemos los datos de envío del JSON
                        String metodo = extractJsonField(line, "metodo_entrega");
                        String region = extractJsonField(line, "region");
                        String ciudad = extractJsonField(line, "ciudad");
                        String calle = extractJsonField(line, "calle");
                        String numero = extractJsonField(line, "numero");
                        String cel = extractJsonField(line, "cel");
                        String comentarios = extractJsonField(line, "comentarios");
                        
                        entidades.EntregaPedido entrega = null;
                        if (metodo != null && !metodo.isEmpty()) {
                            entrega = new entidades.EntregaPedido(metodo, region, ciudad, calle, numero, cel, comentarios); 
                        }

                        sistemaAdmin.actualizarCarritoRemoto(
                                extractJsonField(line, "id"),
                                extractJsonField(line, "cliente"),
                                extractJsonField(line, "run"),
                                extractJsonField(line, "estado"),
                                extractJsonField(line, "productos"),
                                entrega,
                                extractJsonField(line, "cupon"),
                                extractJsonField(line, "cupon_porcentaje"));
                        vistas.PanelVentasAdmin.refrescarEnVivo();
                    }
                    continue;
                }

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

                        if (cantidad == 0) {
                            out.println(createJsonMessage("La cantidad debe ser mayor a 0."));
                            continue;
                        }

                        int stockActual;

                        // Buscar, validar, actualizar y leer el stock como una sola operación 
                        synchronized (invent) {
                            Producto p = invent.buscarPorId(id);

                            if (p == null) {
                                out.println(createJsonMessage("Producto no encontrado: " + id));
                                continue;
                            }
                            if (cantidad < 0 && (p.getStock() + cantidad) < 0) {
                                out.println(createJsonMessage("Stock insuficiente para el producto " + id));
                                continue;
                            }

                            invent.actualizarInventario(p, cantidad);
                            stockActual = p.getStock();
                        }
                        if (dashboardTabla != null) {
                            java.awt.EventQueue.invokeLater(() -> {
                                dashboardTabla.actualizarTabla(invent.getProductos());
                            });
                        }
                        broadcast(createJsonData(stockActual, String.valueOf(id)));
                        
                    } catch (NumberFormatException e) {
                        out.println(createJsonMessage("La cantidad y el id deben ser enteros válidos."));
                    }
                }
                if ("message".equals(type)) {
                    String msg = extractJsonField(line, "content");
                    
                    try {
                        String infoProducto = "";
                        
                        // Buscamos si el mensaje menciona algún producto
                        for (Producto p : st.getProductos()) {
                            if (msg != null && msg.toLowerCase().contains(p.getNombre().toLowerCase())) {
                                String nombre = p.getNombre();
                                int stock = p.getStock();
                                int precio = (int) p.getPrecio();
                                infoProducto = "\nDATO DE INVENTARIO: El producto " + nombre 
                                             + " cuesta $" + precio + " y quedan " + stock + " unidades en stock.\n";
                                break;
                            }
                        }   

                        // Construir el prompt completo para PorIA
                        
                        String promptFinal = prontContexto() + "\n"
                                           + "Historial{\n"
                                           + historialCliente.get(out)
                                           + "\n}"
                                           + infoProducto + "\n"
                                           + "Mensaje del cliente: " + msg +"\n";
                                           
                        String respuesta = ApiGemini.callGeminiAPI(promptFinal);
                        
                        
                        historialCliente.replace(out,historialCliente.get(out).append("\nUsuario: ").append(msg).
                                append("\nInformacion dada: ").append(infoProducto).append("\nIA: ").append(respuesta));
                        
                        System.out.println("Historial de conversacion con IA: "+ historialCliente.get(out));
                        
                        if (respuesta != null && respuesta.contains("[AGREGAR:")) {
                            
                            System.out.println("Server: Solicitud de carrito detectada en IA: " + respuesta);
                            Pattern regex = Pattern.compile("\\[AGREGAR:\\s*([^,]+),\\s*(\\d+)\\]");
                            Matcher matcher = regex.matcher(respuesta);
                            if (matcher.find()) {
                                String nombreProducto = matcher.group(1).trim(); 
                                int cantidad = Integer.parseInt(matcher.group(2).trim());
                                System.out.println("[Server] Producto a agregar: " + nombreProducto + " | Cantidad: " + cantidad);  
                                List<Producto> encontrados = invent.buscarPorNombre(nombreProducto);
                                
                                if (!encontrados.isEmpty()) {
                                    Producto prod = encontrados.get(0);
                                    System.out.println("[Server] Encontrado: " + prod.getNombre() + " con ID: " + prod.getId());
                                    out.println("{\"type\": \"agregar_carro\", \"id\": " + prod.getId() + ", \"cantidad\": " + cantidad + "}");
                                }
                            }
                            respuesta = respuesta.replaceAll("\\[AGREGAR:.*?\\]", "").trim();
                        }

                        System.out.println("Mensaje enviado. En espera...");
                        out.println(createJsonMessage(respuesta));
                        
                    } catch (java.net.SocketTimeoutException e) {
                        System.err.println("Timeout IA: " + e.getMessage());
                        out.println(createJsonMessage("Tiempo de espera agotado: la IA tardó demasiado en responder. Intenta nuevamente."));

                    } catch (java.net.UnknownHostException | java.net.ConnectException e) {
                        System.err.println("Sin conexión IA: " + e.getMessage());
                        out.println(createJsonMessage("Sin conexión a internet: no se pudo contactar al servicio de IA."));

                    } catch (SecurityException e) {
                        System.err.println("Error API Key: " + e.getMessage());
                        out.println(createJsonMessage("Error de autenticación: la API Key de la IA es inválida."));

                    } catch (IllegalStateException e) {
                        System.err.println("Límite cuota: " + e.getMessage());
                        out.println(createJsonMessage("Límite de solicitudes excedido: por favor espera unos momentos antes de volver a preguntar."));

                    } catch (Exception e) {
                        System.err.println("Error inesperado IA: " + e.getMessage());
                        out.println(createJsonMessage("Lo siento, ocurrió un error al procesar tu solicitud."));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("[-] Conexión con el cliente interrumpida: " + e.getMessage());
        } finally {
            if (out != null) {
                clientesConectados.remove(out);
                historialCliente.remove(out);
                clientePorCarrito.values().remove(out); // ya no se le pueden mandar avisos de pedido
            }
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("[-] El cliente se ha desconectado.");   
        }
    }
    
    public static void notificarCreacion (Producto p){
        broadcast(createJsonProducto(p));
    }
    //Le avisa al cliente dueño del pedido su numero y estado (si sigue conectado)
    public static void notificarPedido(entidades.Pedido p) {
        PrintWriter clienteOut = clientePorCarrito.get(p.getIdCarritoCliente());
        if (clienteOut == null || !clientesConectados.contains(clienteOut)) {
            return; //el cliente se desconecto
        }
        clienteOut.println("{\"type\": \"pedido\", \"numero\": " + p.getNumero()
                + ", \"estado\": \"" + escapeJson(logica.SistemaTienda.textoEstado(p.getEstado())) + "\"}");
        clienteOut.flush();
    }
    public static void notificarEliminacion (int id){
        String json = "{\"type\": \"eliminar\", \"id\": " + id + "}";
        broadcast(json);   
    }
    private static void broadcast(String mensajeJson) {
        System.out.println("[Server] Difundiendo a " + clientesConectados.size() + " cliente(s): " + mensajeJson);
        for (PrintWriter clienteOut : clientesConectados) {
            try {
                clienteOut.println(mensajeJson); // Envía el cambio actualizado al cliente
                clienteOut.flush();
            } catch (Exception e) {
                // Si falla, el cliente probablemente se desconectó mal, lo removemos
                clientesConectados.remove(clienteOut);
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
    
    // Método para crear el JSON de un solo producto con todos sus datos
    private static String createJsonProducto(Producto p) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"type\": \"").append("get_producto").append("\", ");
        json.append("\"id\": ").append(p.getId()).append(", ");
        json.append("\"nombre\": \"").append(escapeJson(p.getNombre())).append("\", ");
        json.append("\"descripcion\": \"").append(escapeJson(p.getDescripcion())).append("\", ");
        json.append("\"precio\": ").append(p.getPrecio()).append(", ");
        json.append("\"categoria\": \"").append(escapeJson(p.getCategoriaStr())).append("\", ");
        json.append("\"stock\": ").append(p.getStock()).append(", ");
        json.append("\"rutaImagen\": \"").append(escapeJson(p.getRutaImagen())).append("\"");
        json.append("}");
        return json.toString();
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
    private static String prontContexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("Eres PorIA, el asistente virtual oficial de PoriStore. Ya te presente, no es necesario que saludes o te presentes cuando te hablen, si y solo si te saluden primero\n");
        sb.append("Responde en español de forma amable, breve y profesional.\n");
        sb.append("Solo puedes responder consultas sobre la tienda, productos, precios y disponibilidad.\n\n");
        sb.append("REGLA DE INVENTARIO: Solo puedes hablar de precios y stock según lo que se indique en 'DATO DE INVENTARIO' o lo que ya se informó en el HISTORIAL.\n\n");
        sb.append("REGLA DE CONTEXTO: Si el cliente no nombra el producto explícitamente (por ejemplo dice 'quiero comprar 10', 'agrégalo', 'cuánto vale?'), revisa el HISTORIAL para saber de qué producto habla y responde usando ese contexto.\n\n");
        sb.append("REGLA DE COMPRA: Si el cliente pide comprar o agregar un producto al carrito, responde cordialmente y escribe al final exactamente: [AGREGAR: nombre_del_producto, cantidad]. Si no lo pide, NO agregues esa etiqueta.");
        return sb.toString();
    }
}