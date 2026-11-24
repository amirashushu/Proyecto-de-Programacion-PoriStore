package entidades;

import java.io.Serializable;


public class Producto implements Serializable{
    
    private static final long serialVersionUID = 491618266471120506L;
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private Categorias categoria;
    private String rutaImagen;
    private double ofertaPorcentaje; // % de descuento de la oferta (0 = sin oferta)
    private java.time.LocalDate ofertaHasta; 


    public Producto(int id, String nombre, String descripcion, double precio, int stock, Categorias categoria, String rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.rutaImagen = rutaImagen; 

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //Precio que paga el cliente, el de oferta mientras la oferta este vigente, si no el normal
    public double getPrecio() {
        if (tieneOferta()) {
            return Math.round(precio * (1 - ofertaPorcentaje / 100));
        }
        return precio;
    }   
    public double getPrecioBase(){
        return precio;
    }
    //La oferta esta vigente hasta el final del dia de ofertaHasta, despues se apaga sola
    public boolean tieneOferta() {
        return ofertaPorcentaje > 0 && ofertaHasta != null && !java.time.LocalDate.now().isAfter(ofertaHasta);
    }

    public double getOfertaPorcentaje() {
        return ofertaPorcentaje;
    }

    public java.time.LocalDate getOfertaHasta() {
        return ofertaHasta;
    }

    public void setOferta(double porcentaje, java.time.LocalDate hasta) {
        this.ofertaPorcentaje = porcentaje;
        this.ofertaHasta = hasta;
    }

    public void quitarOferta() {
        this.ofertaPorcentaje = 0;
        this.ofertaHasta = null;
    }

    public int getStock() {
        return stock;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    public String getImagen() {
    return this.rutaImagen;
    }
    public String getCategoriaStr(){
        return categoria.toString().trim();
    }
}
