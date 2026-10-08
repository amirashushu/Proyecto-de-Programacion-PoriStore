
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ventas implements Serializable{
    private Carro carroVenta;
    private int idVenta;
    private LocalDate fecha;
    public Ventas(Carro c,int idGenerado){
        this.carroVenta = c;
        this.idVenta = idGenerado;
        this.fecha = LocalDate.now();
    }

    public Carro getCarroVenta() {
        return carroVenta;
    }

    public void setCarroVenta(Carro carroVenta) {
        this.carroVenta = carroVenta;
    }

    

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
    
}
