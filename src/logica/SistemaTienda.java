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

public class SistemaTienda implements Serializable{
    private ArrayList<Producto> inventario;
    private Administrador admin;
    
    

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

    public boolean actualizarProducto(int id, String nombre, String descripcion, double precio, int stock, Categorias categoria) {
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
