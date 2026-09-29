
package entidades;

import java.util.HashMap;
import java.util.Map;

public class Carro {
    private static int numero = 0;
    private final HashMap<Producto,Integer> carritoProductos;
    private String nombre;
    private String run;
    private String estado;
    
    public Carro(String nombre, String run){
        numero++;
        this.carritoProductos = new HashMap<>();
        this. nombre = nombre;
        this.run = run;
        this.estado = "Por pagar";
    }
    //Logica carritoProductos
    public boolean agregarProCarrito(Producto p, int cant){
        int s = p.getStock();
        if (s >= cant){
            if (!carritoProductos.containsKey(p)){
                carritoProductos.put(p, cant);
            }else{
                Integer cAntiguo = carritoProductos.get(p);
                carritoProductos.put(p, cAntiguo+cant);    
            }
            p.setStock(s-cant);
            return true;
        }
        return false;
    }

    // Eliminar producto del carritoProductos por ID
    public boolean eliminarProductoCarrito(int id) {
        Producto productoAEliminar = null;
        for (Producto p : carritoProductos.keySet()) {
            if (p.getId() == id) {
                productoAEliminar = p;
                break;
            }
        }
        if (productoAEliminar != null) {
            int cantidad = carritoProductos.get(productoAEliminar);
            productoAEliminar.setStock(productoAEliminar.getStock() + cantidad);  //  Restaura stock
            carritoProductos.remove(productoAEliminar);  // Elimina del carritoProductos
            return true;
        }
        return false;
    }

    public void vaciarCarrito(){
        for (Map.Entry<Producto, Integer> entrada : carritoProductos.entrySet()) {
            Producto p= entrada.getKey();
            int c = entrada.getValue();
            p.setStock(p.getStock()+c);
            carritoProductos.remove(p, c);
        }
    }
    
    //Calculos matemáticos
    private double calcularSubTotal(){
        double total = 0.0;
        for (Map.Entry<Producto, Integer> entry : carritoProductos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
        
            total += producto.getPrecio() * cantidad;
        }
        return total;
    }
    
    private double calcularTotal(){
        double total = calcularSubTotal();
        total = total * 1.19;
        return total;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Carro.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public HashMap<Producto, Integer> getCarritoProductos() {
        return carritoProductos;
    }
    
    
    

    
}
