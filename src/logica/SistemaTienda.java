package logica;

import entidades.Administrador;
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
import java.util.HashMap;

public class SistemaTienda implements Serializable{
    private ArrayList<Producto> inventario;
    private Administrador admin;
    private HashMap<String,Administrador> cuentas = new HashMap<>();
    

    public SistemaTienda() {
        this.inventario = new ArrayList<>();
    }

    // Generador de ID automatico
    public int generarSiguienteId() {
        int maxId = 0;
        for (Producto p : inventario) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    //Agregar producto a inventario
    public void agregarProducto(Producto p){
        inventario.add(p);
    }

    public Producto buscarPorId(int id) {
        for (Producto p : inventario) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

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

    public boolean eliminarProducto(int id) {
        return inventario.removeIf(p -> p.getId() == id);
    }

    public List<Producto> getProductos() {
        return inventario;
    }

    // Busqueda en memoria
    public List<Producto> buscarPorNombre(String patron) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : inventario) {
            if (p.getNombre().toLowerCase().contains(patron.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    public void crearProducto(String nombre, String descrip, double precio, int stock, Categorias cat){
        int nuevoId = this.generarSiguienteId();
        Producto nuevo = new Producto(nuevoId, nombre, descrip, precio, stock, cat);
        this.agregarProducto(nuevo);
    }
   
    
    public boolean registrarse(String correo, String contraseña, String nombre){
        if (cuentas.containsKey(correo)){
           return false;  
        }else{
            Administrador admin = new Administrador(nombre, contraseña, correo);
            cuentas.put(correo, admin);
            return true;
        }
    }
    public boolean iniciarSesion(String correo, String contraseña){
        if (cuentas.containsKey(correo)){
        return cuentas.get(correo).validarContraseña(contraseña);
        }
        return false;
    }
// Calculos


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


    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto producto : inventario) {
            double valorProducto = producto.getPrecio() * producto.getStock();
            total += valorProducto;
        }
        return total;
    }


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
    
    public void guardarDatos() { //serializar, guardar datos
    try {
        ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream("datosPoriStore.dat"));

        salida.writeObject(this);
        salida.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    public static SistemaTienda cargarDatos() {  //cargar datos
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
