package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import server.Server;

public class Inventario implements Serializable{
    private final ArrayList<Producto> inventario;

    public Inventario() {
        this.inventario = new ArrayList<>();
    }
        // ========== GESTIÓN DE PRODUCTOS ==========

    // Genera un ID único autogenerado para productos nuevos
    public int generarSiguienteId() {
        int maxId = 0;
        for (Producto p : inventario) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    // Agrega un producto al inventario
    public void agregarProducto(Producto p){
        inventario.add(p);
    }

    // Busca un producto específico por su ID en el inventario
    public Producto buscarPorId(int id) {
        for (Producto p : inventario) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Actualiza todos los atributos de un producto existente
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

    // Actualiza todos los atributos de un producto existente con imagen
    public boolean actualizarProducto(String nombre, String descripcion, double precio, int stock, Categorias categoria, int id, String rutaImagen) {
        Producto p = buscarPorId(id);
        if (p != null) {
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setPrecio(precio);
            p.setStock(stock);
            p.setCategoria(categoria);
            p.setRutaImagen(rutaImagen);
            Server.notificarCreacion(p);
            return true;
        }
        return false;
    }
    public boolean actualizarProductoCliente(String nombre, String descripcion, double precio, int stock, Categorias categoria, int id, String rutaImagen) {
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
    // Elimina un producto del inventario por su ID
    public boolean eliminarProducto(int id) {
        if (inventario.removeIf(p -> p.getId() == id)){
            Server.notificarEliminacion(id);
            return true;
        }
        return false;
    }

    public List<Producto> getProductos() {
        return inventario;
    }

    // Busca productos cuyo nombre contenga el patrón especificado
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
        Server.notificarCreacion(nuevo);
    }
    //aquí se crea el producto ya creado en el server, y se envia y se crea denuevo en cliente, con la informacion dada por el server
    public void reCrearProducto(int id, String nombre, String descrip, double precio, int stock, Categorias cat, String rutaImagen){
        Producto nuevo = new Producto(id, nombre, descrip, precio, stock, cat, rutaImagen);
        this.agregarProducto(nuevo);
    }
    // ========== CÁLCULOS MATEMÁTICOS INVENTARIO==========
    
     // Calcula el valor monetario total del inventario
    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto producto : inventario) {
            double valorProducto = producto.getPrecio() * producto.getStock();
            total += valorProducto;
        }
        return total;
    }

    // Cuenta el número total de productos en el inventario
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

    // Filtra productos por categoría
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

    // Filtra productos por rango de precios
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
    public void actualizarInventario(Producto p, int cantP){     
        p.setStock(p.getStock()+cantP);
    }
}
