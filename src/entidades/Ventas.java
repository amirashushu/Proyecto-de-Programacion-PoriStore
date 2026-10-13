
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ventas implements Serializable{
    private Carro carroVenta;
    private int idVenta;
    private LocalDate fecha;
    private LocalTime hora;
    
    public Ventas(Carro c,int idGenerado){
        this.carroVenta = c;
        this.idVenta = idGenerado;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
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

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public String getHoraFormateada(){
        LocalTime hora = this.getHora();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        String horaFormateada = hora.format(myFormatObj);
        return horaFormateada;
    }
    
    
    
    
    
    
    
    
    
    
    
}
