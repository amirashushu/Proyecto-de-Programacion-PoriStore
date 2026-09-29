
package entidades;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idSesion;  // ID unico para identificar el carrito 
    private final HashMap<Producto,Integer> carritoProductos;
    private Cliente cliente;  // Cliente dueño del carrito (null si es anónimo)
    private String estado;

    // Carrito empieza anónimo por defecto
    public Carro(){
        this.idSesion = UUID.randomUUID().toString();
        this.carritoProductos = new HashMap<>();
        this.cliente = null;  
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

    public String getIdSesion() {
        return idSesion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Retorna true si es un carrito anon
    public boolean esAnonimo() {
        return cliente == null;
    }

    // Identificador completo del carrito para Admin
    public String getIdentificador() {
        if (cliente != null) {
            return cliente.getNombre() + " (" + cliente.getCorreo() + ")";
        } else {
            return "Cliente Anónimo #" + idSesion.substring(0, 8);
        }
    }

    public String getNombre() {
        return cliente != null ? cliente.getNombre() : "Anónimo";
    }

    public String getRun() {
        return cliente != null ? cliente.getRut() : null;
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

    public double getSubTotal() {
        return calcularSubTotal();
    }

    public double getTotal() {
        return calcularTotal();
    }
}
