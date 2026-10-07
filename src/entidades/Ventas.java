
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ventas implements Serializable{
    private Carro carroVenta;
    private static int idVenta = 1;
    private LocalDate fecha;
    public Ventas(Carro c){
        this.carroVenta = carroVenta;
        this.idVenta++;
        this.fecha = LocalDate.now();
    }

    public Carro getCarroVenta() {
        return carroVenta;
    }

    public void setCarroVenta(Carro carroVenta) {
        this.carroVenta = carroVenta;
    }

    public static int getIdVenta() {
        return idVenta;
    }

    public static void setIdVenta(int idVenta) {
        Ventas.idVenta = idVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
    
}
