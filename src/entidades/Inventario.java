package entidades;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    // Generador de ID automatico
    public int generarSiguienteId() {
        int maxId = 0;
        for (Producto p : listaProductos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    // CRUD en memoria
    public boolean agregarProducto(Producto p) {
        if (buscarPorId(p.getId()) != null) {
            return false;
        }
        listaProductos.add(p);
        return true;
    }

    public Producto buscarPorId(int id) {
        for (Producto p : listaProductos) {
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
        return listaProductos.removeIf(p -> p.getId() == id);
    }

    public List<Producto> getProductos() {
        return listaProductos;
    }

    // Busqueda en memoria
    public List<Producto> buscarPorNombre(String patron) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : listaProductos) {
            if (p.getNombre().toLowerCase().contains(patron.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
