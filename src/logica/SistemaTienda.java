package logica;

import entidades.Administrador;
import entidades.Carro;
import entidades.Categorias;
import entidades.Cliente;
import entidades.Inventario;
import entidades.Producto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import server.Server;

public class SistemaTienda implements Serializable{
    private static final long serialVersionUID = 1L;

    
    private ArrayList<Carro> carritos;  // Múltiples carritos 
    private final HashMap<String,Administrador> cuentas;
    private final HashMap<String,Cliente> clientes;  // Clientes registrados 
    private Inventario inventario;
    public SistemaTienda() {
        this.carritos = new ArrayList<>();
        this.cuentas = new HashMap<>();
        this.clientes = new HashMap<>();
        this.inventario = new Inventario();
        // Crear admin por defecto si no existe
        crearAdminPorDefecto();
    }

    // Crea un administrador por defecto con credenciales admin/admin
    private void crearAdminPorDefecto() {
        String correoAdmin = "admin";
        if (!cuentas.containsKey(correoAdmin)) {
            Administrador adminDefault = new Administrador("Administrador", "admin", correoAdmin);
            cuentas.put(correoAdmin, adminDefault);
        }
    }



    // ========== GESTIÓN DE ADMINISTRADORES ==========

    // Registra un nuevo administrador en el sistema
    public boolean registrarse(String correo, String contraseña, String nombre){
        if (cuentas.containsKey(correo)){
           return false;
        }else{
            Administrador admin = new Administrador(nombre, contraseña, correo);
            cuentas.put(correo, admin);
            return true;
        }
    }

    // Valida las credenciales de un administrador
    public boolean iniciarSesion(String correo, String contraseña){
        if (cuentas.containsKey(correo)){
            if(cuentas.get(correo).validarContraseña(contraseña)){
                new Thread(() -> {
                Server servidor = new Server();
                servidor.initServer(inventario);
                }).start();
                return true;
            }
        }
        return false;
    }

    // Verifica si las credenciales corresponden al admin por defecto
    public boolean esAdmin(String correo, String contraseña) {
        return correo.equals("admin") && contraseña.equals("admin");
    }

    // ========== GESTIÓN DE CLIENTES ==========

    // Registra un nuevo cliente en el sistema
    public boolean registrarCliente(String rut, String nombre, String correo, String contraseña) {
        if (clientes.containsKey(correo)) {
            return false; // Correo ya registrado
        }
        Cliente nuevoCliente = new Cliente(rut, nombre, correo, contraseña);
        clientes.put(correo, nuevoCliente);
        return true;
    }

    // Valida las credenciales de un cliente
    public boolean iniciarSesionCliente(String correo, String contraseña) {
        if (clientes.containsKey(correo)) {
            return clientes.get(correo).validarContraseña(contraseña);
        }
        return false;
    }

    // Obtiene un cliente por su correo
    public Cliente obtenerCliente(String correo) {
        return clientes.get(correo);
    }

    public HashMap<String,Cliente> getClientes() {
        return clientes;
    }
    // ========== METODOS PUENTES DE PRODUCTO ==========
    public void crearProducto(String nombre, String descrip, double precio, int stock, Categorias cat, String rutaImagen){
        inventario.crearProducto(nombre, descrip, precio, stock, cat, rutaImagen);
    }
    public List<Producto> getProductos(){
        return inventario.getProductos();
    }
    public boolean actualizarProducto(String nombre, String descripcion, double precio, int stock, Categorias categoria, int id, String rutaImagen){
        return inventario.actualizarProducto(nombre, descripcion, precio, stock, categoria, id, rutaImagen);
    }
    public List<Producto> buscarPorNombre(String patron){
        return inventario.buscarPorNombre(patron);
    }
    public boolean eliminarProducto(int id){
        return inventario.eliminarProducto(id);
    }
    public List<Producto> filtrarPorCategoria(String categoria){
        return inventario.filtrarPorCategoria(categoria);
    }
    public List<Producto> filtrarPorPrecio(double precioMin, double precioMax){
        return inventario.filtrarPorPrecio(precioMin, precioMax);
    }
    public double calcularValorTotalInventario() {
        return inventario.calcularValorTotalInventario();
    }
    public int calcularTotalProductos(){
        return inventario.calcularTotalProductos();
    }
    public Producto buscarPorId(int id){
        return inventario.buscarPorId(id);
    }
    // ========== GESTIÓN DE CARRITOS ==========

   
     //Obtiene el carrito actual basado en la sesión de GestorSesion funciona automáticamente para clientes anónimos y registrados.

    public Carro obtenerCarritoActual() {
        Cliente clienteActual = GestorSesion.getClienteActual();

        if (clienteActual != null) {
            // CLIENTE REGISTRADO

            // 1. Buscar carrito registrado a su nombre
            for (Carro c : carritos) {
                if (c.getEstado().equals("Por pagar") &&
                    c.getCliente() != null &&
                    c.getCliente().getCorreo().equals(clienteActual.getCorreo())) {
                    return c;
                }
            }

            // 2. No tiene carrito registrado, buscar carrito anónimo activo
            //    (caso: usuario agregó productos como anónimo y luego hizo login)
            for (Carro c : carritos) {
                if (c.getEstado().equals("Por pagar") && c.getCliente() == null) {
                    // Vincular carrito anónimo al cliente automáticamente
                    c.setCliente(clienteActual);
                    return c;
                }
            }

            // 3. No hay ningún carrito, crear uno nuevo
            Carro nuevo = new Carro();
            nuevo.setCliente(clienteActual);
            carritos.add(nuevo);
            return nuevo;

        } else {
            // CLIENTE ANÓNIMO

            // Buscar carrito anónimo activo
            for (Carro c : carritos) {
                if (c.getEstado().equals("Por pagar") && c.getCliente() == null) {
                    return c;
                }
            }

            // No existe, crear uno nuevo
            Carro nuevo = new Carro();
            carritos.add(nuevo);
            return nuevo;
        }
    }

    // Obtener el carrito activo de un cliente específico (para uso admin)
    public Carro obtenerCarritoCliente(Cliente cliente) {
        for (Carro c : carritos) {
            if (c.getCliente() != null &&
                c.getCliente().getCorreo().equals(cliente.getCorreo()) &&
                c.getEstado().equals("Por pagar")) {
                return c;
            }
        }
        // Si no existe, crear uno nuevo
        Carro nuevo = new Carro();
        nuevo.setCliente(cliente);
        carritos.add(nuevo);
        return nuevo;
    }

    // Obtener todos los carritos
    public ArrayList<Carro> getCarritos() {
        return carritos;
    }

    // Obtener carritos activos (pendientes de pago)
    public ArrayList<Carro> getCarritosActivos() {
        ArrayList<Carro> activos = new ArrayList<>();
        for (Carro c : carritos) {
            if (c.getEstado().equals("Por pagar")) {
                activos.add(c);
            }
        }
        return activos;
    }

    // Confirmar compra de un carrito
    public void confirmarCompra(Carro c){
        c.setEstado("Pagado");
    }

    // Cancelar compra y vaciar carrito
    public void cancelarCompra(Carro c){
        c.vaciarCarrito();
        carritos.remove(c);
    }
    
    

    // ========== CÁLCULOS MATEMÁTICOS ==========

    // Calcula el valor total del inventario formateado
    public String obtenerValorTotalFormateado() {
        double total = inventario.calcularValorTotalInventario();
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CL"));
        return formatoMoneda.format(total);
    }

    // Calcula el precio promedio de productos de una categoría
    public double calcularPrecioPromedio(String categoria) {
        List<Producto> productosDeCategoria = inventario.filtrarPorCategoria(categoria);
        if (productosDeCategoria.isEmpty()) {
            return 0.0;
        }
        double sumaPrecios = 0;
        for (Producto producto : productosDeCategoria) {
            sumaPrecios += producto.getPrecio();
        }
        int cantidad = productosDeCategoria.size();
        return sumaPrecios / cantidad;
    }

    // Obtiene el producto con menor stock de una categoría
    public Producto obtenerProductoMenorStock(String categoria) {
        List<Producto> productosDeCategoria = inventario.filtrarPorCategoria(categoria);
        if (productosDeCategoria.isEmpty()) {
            return null;
        }
        Producto productoMenorStock = productosDeCategoria.get(0);

        for (Producto producto : productosDeCategoria) {
            if (producto.getStock() < productoMenorStock.getStock()) {
                productoMenorStock = producto;
            }
        }
        return productoMenorStock;
    }

    // ========== PERSISTENCIA  ==========

    // Guarda todo el sistema en archivo binario
    public void guardarDatos() {
    try {
        ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream("datosPoriStore.dat"));

        salida.writeObject(this);
        salida.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    // Carga el sistema desde el archivo
    public static SistemaTienda cargarDatos() {
    try {
        ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream("datosPoriStore.dat"));

        SistemaTienda sistema = (SistemaTienda) entrada.readObject();

        entrada.close();
        return sistema;

    } catch (Exception e) {
        return new SistemaTienda();
    }
    }
    
}

