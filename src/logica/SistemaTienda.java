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

    
    private ArrayList<Carro> carritos;  // Múltiples carritos (compras)
    private Carro carritoAnonimo;
    private final HashMap<String,Administrador> cuentas;
    private final HashMap<String,Cliente> clientes;  // Clientes registrados 
    private final Inventario inventario;
    public SistemaTienda() {
        this.carritos = new ArrayList<>();
        this.cuentas = new HashMap<>();
        this.clientes = new HashMap<>();
        this.inventario = new Inventario();
        this.carritoAnonimo = new Carro();
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
                if (esAdmin(correo, contraseña)){
                    new Thread(() -> {
                    Server servidor = new Server();
                    servidor.initServer(inventario);
                    }).start();
                }
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
    public void crearProducto(String nombre, String descrip, double precio, int stock, Categorias cat){
        inventario.crearProducto(nombre, descrip, precio, stock, cat);       
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
    // Revisa si el nombre ya lo usa otro producto (idExcluido = producto que se edita, -1 si es nuevo)
    public boolean existeNombre(String nombre, int idExcluido){
        return inventario.existeNombre(nombre, idExcluido);
    }
    // ========== GESTIÓN DE CARRITOS ==========

    public Carro obtenerCarritoActual() { //obtiene el carrito actual
        Cliente clienteActual = GestorSesion.getClienteActual();

        if (clienteActual != null) {
            //para cliente registrado
            
            // Si el cliente acaba de iniciar sesión y había metido cosas al carrito anónimo, le traspasamos ese carrito anónimo a su cuenta.
            if (!carritoAnonimo.getCarritoProductos().isEmpty()) {
                carritoAnonimo.setCliente(clienteActual);
                clienteActual.setCarritoActual(carritoAnonimo);
                carritoAnonimo = new Carro();      //se genera un nuevo carrito anónimo vacío para el sistema
            }  
            
            return clienteActual.getCarritoActual();
        } else {
            return carritoAnonimo;
        }
    }


    // Obtener carritos activos (pendientes de pago) // Agregar el de pagado(?)
    public ArrayList<Carro> getCarritosActivos() {
        ArrayList<Carro> activos = new ArrayList<>();
        for (Carro c : carritos) {
            if (c.getEstado().equals("Por pagar")) {
                activos.add(c);
            }
        }
        return activos;
    }

    // Unidades de un producto apartadas en carritos que aún no se pagan
    public int calcularReservado(Producto p) {
        int reservado = 0;
        for (Carro c : getCarritosActivos()) {
            Integer cantidad = c.getCarritoProductos().get(p);
            if (cantidad != null) {
                reservado += cantidad;
            }
        }
        return reservado;
    }

    // Obtener todos los carritos
    public ArrayList<Carro> getCarritos() {
        return carritos;
    }

    // Confirmar compra de un carrito
    public void confirmarCompra(Carro c){
        c.setEstado("Pagado");
        carritos.add(c); //se guarda en la lista de ventas
        //le asignamos un carrito nuevo y vacío al usuario
        Cliente cliente = c.getCliente();
        if (cliente != null) {
            Carro nuevoCarro = new Carro();
            nuevoCarro.setCliente(cliente);
            cliente.setCarritoActual(nuevoCarro);
        } else {
            //reiniciamos el carrito anónimo
            this.carritoAnonimo = new Carro();
        }
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

    public Inventario getInventario() {
        return inventario;
    }
    
    
}

