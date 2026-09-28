package logica;

import entidades.Administrador;
import entidades.Carro;
import entidades.Categorias;
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
import java.util.Map;

public class SistemaTienda implements Serializable{
    private final ArrayList<Producto> inventario;
    private Administrador admin;
    private ArrayList<Carro> carritos;
    private final HashMap<String,Administrador> cuentas;
   
    public SistemaTienda() {
        this.inventario = new ArrayList<>();
        this.cuentas = new HashMap<>();
        this.carritos = new ArrayList<>();
    }

    // Genera un ID único autogenerado para productos nuevos
    // Busca el ID mas alto en el inventario actual y retorna ese valor + 1
    public int generarSiguienteId() {
        int maxId = 0;
        for (Producto p : inventario) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    // Agrega un producto al inventario (ArrayList de productos)
    public void agregarProducto(Producto p){
        inventario.add(p);
    }

    // Busca un producto específico por su ID en el inventario
    // Retorna el objeto Producto si lo encuentra, o null si el ID no existe
    public Producto buscarPorId(int id) {
        for (Producto p : inventario) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Actualiza todos los atributos de un producto existente buscándolo por su ID
    // Retorna true si el producto existe y se actualizo, false si el ID no existe en el inventario
    public boolean actualizarProducto(String nombre, String descripcion, double precio, int stock, Categorias categoria, int id) {
        Producto p = buscarPorId(id);
        if (p != null) {
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setStock(stock);
            p.setCategoria(categoria);
            return true;
        }
        return false;
    }

    // Actualiza todos los atributos de un producto existente
    public boolean actualizarProducto(String nombre, String descripcion, double precio, int stock, Categorias categoria, int id, String rutaImagen) {
        Producto p = buscarPorId(id);
        if (p != null) {
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setStock(stock);
            p.setCategoria(categoria);
            p.setRutaImagen(rutaImagen);
            return true;
        }
        return false;
    }

    // Elimina un producto del inventario buscándolo por su ID
    // Retorna true si el producto fue encontrado y eliminado, false si el ID no existe
    public boolean eliminarProducto(int id) {
        return inventario.removeIf(p -> p.getId() == id);
    }

    public List<Producto> getProductos() {
        return inventario;
    }

    // Busca productos cuyo nombre contenga el patrón especificado (búsqueda parcial)
    // La búsqueda no distingue entre mayúsculas y minusculas. Retorna lista de coincidencias
    public List<Producto> buscarPorNombre(String patron) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : inventario) {
            if (p.getNombre().toLowerCase().contains(patron.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Crea un producto nuevo con ID autogenerado (usa imagen por defecto)
    public void crearProducto(String nombre, String descrip, double precio, int stock, Categorias cat){
        crearProducto(nombre, descrip, precio, stock, cat, "/fotos/producto.png");
    }

    // Crea un producto nuevo con ID autogenerado e imagen personalizada
    public void crearProducto(String nombre, String descrip, double precio, int stock, Categorias cat, String rutaImagen){
        int nuevoId = this.generarSiguienteId();
        Producto nuevo = new Producto(nuevoId, nombre, descrip, precio, stock, cat, rutaImagen);
        this.agregarProducto(nuevo);
    }


    // Registra un nuevo administrador en el sistema con sus credenciales
    // Retorna false si el correo ya está registrado, true si se creó la cuenta exitosamente
    public boolean registrarse(String correo, String contraseña, String nombre){
        if (cuentas.containsKey(correo)){
           return false;
        }else{
            Administrador admin = new Administrador(nombre, contraseña, correo);
            cuentas.put(correo, admin);
            return true;
        }
    }

    // Valida las credenciales de inicio de sesión 
    // Retorna true si el correo existe y la contraseña es correcta, false en caso contrario
    public boolean iniciarSesion(String correo, String contraseña){
        if (cuentas.containsKey(correo)){
            return cuentas.get(correo).validarContraseña(contraseña);
        }
        return false;
    }
    

// ========== CÁLCULOS MATEMÁTICOS ==========


    // Calcula el valor total del inventario y lo formatea en pesos chilenos (CLP)
    // Retorna String con formato de moneda: $15.750.000 (con separadores de miles)
    public String obtenerValorTotalFormateado() {
        double total = calcularValorTotalInventario();
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CL"));
        return formatoMoneda.format(total);
    }

    // CÁLCULO MATEMATICO 1: Calcula el precio promedio de productos de una categoría específica
    // Suma todos los precios y divide por cantidad. Retorna 0.0 si la categoria esta vacia (evita división por cero)
    public double calcularPrecioPromedio(String categoria) {
        List<Producto> productosDeCategoria = filtrarPorCategoria(categoria);
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

    // CÁLCULO MATEMATICO 2: Obtiene el producto con menor stock dentro de una categoría específica
    // Compara el stock de todos los productos de la categoría. Retorna null si la categoría está vacía
    public Producto obtenerProductoMenorStock(String categoria) {
        List<Producto> productosDeCategoria = filtrarPorCategoria(categoria);
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

    // CÁLCULO MATEMATICO 3: Calcula el valor monetario total del inventario completo
    // Multiplica precio x stock de cada producto y suma todos los resultados
    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto producto : inventario) {
            double valorProducto = producto.getPrecio() * producto.getStock();
            total += valorProducto;
        }
        return total;
    }

    // Cuenta el numero total de productos actualmente en el inventario
    public int calcularTotalProductos(){
        int cant = 0;
        if(inventario.isEmpty()){
            return cant;
        } else {
            cant = inventario.size();
            return cant;
        }
    }

// ========== FILTROS Y BÚSQUEDA ==========

    // Filtra y retorna solo los productos que pertenecen a una categoría específica
    // Si la categoría es "Todas", retorna el inventario completo sin filtrar
    public List<Producto> filtrarPorCategoria(String categoria) {
        if (categoria.equals("Todas")) {
            return new ArrayList<>(inventario);
        }
        List<Producto> productosFiltrados = new ArrayList<>();
        Categorias categoriaEnum = Categorias.valueOf(categoria);

        for (Producto producto : inventario) {
            if (producto.getCategoria() == categoriaEnum) {
                productosFiltrados.add(producto);
            }
        }

        return productosFiltrados;
    }


    // Filtra productos por rango de precios inclusivo [mínimo, maximo]
    // Solo aplica los límites si son mayores a 0. Retorna lista de productos dentro del rango
    public List<Producto> filtrarPorPrecio(double precioMin, double precioMax) {
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : inventario) {
            double precio = producto.getPrecio();

            boolean dentroDeLimites = true;

            if (precioMin > 0 && precio < precioMin) {
                dentroDeLimites = false;
            }

            if (precioMax > 0 && precio > precioMax) {
                dentroDeLimites = false;
            }

            if (dentroDeLimites) {
                productosFiltrados.add(producto);
            }
        }

        return productosFiltrados;
    }
    
// ========== PERSISTENCIA  ==========

    // Serializa y guarda todo el sistema (inventario + cuentas) en archivo binario datosPoriStore.dat
    // Se llama automáticamente después de cada operación CRUD (crear, actualizar, eliminar)
    public void guardarDatos() {
    try {
        ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream("datosPoriStore.dat"));

        salida.writeObject(this);  // Serializa el objeto completo SistemaTienda
        salida.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    // Deserializa y carga el sistema desde el archivo datosPoriStore.dat al iniciar la aplicación
    // Si el archivo no existe o hay error, retorna una instancia vacía de SistemaTienda (no crashea)
    public static SistemaTienda cargarDatos() {
    try {
        ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream("datosPoriStore.dat"));

        SistemaTienda sistema = (SistemaTienda) entrada.readObject();  // Deserializa

        entrada.close();
        return sistema;

    } catch (Exception e) {
        return new SistemaTienda();  // Si hay error, retorna instancia vacía
    }
    }
    
    //Confirmar y cancelar compra
    public void confirmarCompra(Carro c){
        c.setEstado("Pagado");
    }

    public void cancelarCompra(Carro c){
        c.vaciarCarrito();
        carritos.remove(c);
    }
    
    
}
