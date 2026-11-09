
package entidades;
import java.io.Serializable;
import java.time.LocalDate;

public class Cupon implements Serializable {
    
    private String codigo;
    private double porcentaje;
    private int usos;
    private LocalDate creacion;
    private int dias;

    public Cupon(String codigo, double porcentaje, int usos, int dias, LocalDate creacion) {
        this.codigo = codigo;
        this.porcentaje = porcentaje;
        this.usos = usos;
        this.creacion = creacion;
        this.dias = dias;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public int getUsos() {
        return usos;
    }

    public LocalDate getCreacion() {
        return creacion;
    }

    public int getDias() {
        return dias;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }
    
    public boolean validarCupon(String c){
        return this.codigo.equals(c);
    }
    
    
    
}
