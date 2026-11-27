package entidades;

/**
 *
 * @author Amira
 */
import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String rut;
    private String nombre;
    private String correo;
    private String contraseña;
    private Carro carritoActual;

    public Cliente(String rut, String nombre, String correo, String contraseña) {
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.carritoActual = new Carro();
        this.carritoActual.setCliente(this);
    }
    
    private java.util.List<String> listaDeseos = new java.util.ArrayList<>();
    
    public java.util.List<String> getListaDeseos() {
    if (listaDeseos == null) {
        listaDeseos = new java.util.ArrayList<>();
    }
    return listaDeseos;
    }
    
    public boolean agregarADeseos(String idProducto) {
    if (!getListaDeseos().contains(idProducto)) {
        getListaDeseos().add(idProducto);
        return true;
    }
    return false; 
    }
    
    public boolean quitarDeDeseos(String idProducto) {
    return getListaDeseos().remove(idProducto);
    }

    public boolean tieneEnDeseos(String idProducto) {
    return getListaDeseos().contains(idProducto);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    public Carro getCarritoActual() {
        return carritoActual;
    }

    public void setCarritoActual(Carro carritoActual) {
        this.carritoActual = carritoActual;
    }
    
    
    
    
}
