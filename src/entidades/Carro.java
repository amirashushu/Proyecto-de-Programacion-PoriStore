
package entidades;

import hostCliente.HostCliente;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idSesion;  // ID unico para identificar el carrito 
    private final HashMap<Producto,Integer> carritoProductos;
    private Cliente cliente;  // Cliente dueño del carrito (null si es anónimo)
    private String estado;
    private LocalDate fechaCompra; //Se actualiza cuando se realiza la compra

    // Carrito empieza anónimo por defecto
    public Carro(){
        this.idSesion = UUID.randomUUID().toString();
        this.carritoProductos = new HashMap<>();
        this.cliente = null;  
        this.estado = "Por pagar";
        this.fechaCompra = null;
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
            HostCliente.notificarPeticion(p.getId(), -cant);
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
            HostCliente.notificarPeticion(id, cantidad); //  Restaura stock
            carritoProductos.remove(productoAEliminar);  // Elimina del carritoProductos            
            return true;
        }
        return false;
    }

    public void vaciarCarrito(){
        for (Map.Entry<Producto, Integer> entrada : carritoProductos.entrySet()) {
            Producto p= entrada.getKey();
            int c = entrada.getValue();
            HostCliente.notificarPeticion(p.getId(), c);
        }
        carritoProductos.clear();
    }

    // Cambia la cantidad de un producto ajustando el stock por la diferencia (0 = eliminar)
    public boolean actualizarCantidad(int id, int nuevaCantidad) {
        for (Producto p : carritoProductos.keySet()) {
            if (p.getId() == id) {
                if (nuevaCantidad <= 0) {
                    return eliminarProductoCarrito(id);
                }
                int diferencia = nuevaCantidad - carritoProductos.get(p);
                if (diferencia > p.getStock()) {
                    return false;
                }
                p.setStock(p.getStock() - diferencia);
                carritoProductos.put(p, nuevaCantidad);
                return true;
            }
        }
        return false;
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
        
        return (int) calcularSubTotal();
    }

    public double getTotal() {
        return (int) calcularTotal();
    }

    public double getIVA() {
        return (int) calcularSubTotal() * 0.19;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    
}
