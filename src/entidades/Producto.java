package entidades;

import java.io.Serializable;


public class Producto implements Serializable{

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private Categorias categoria;
    private String rutaImagen;


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

    public double getPrecio() {
        return precio;
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
