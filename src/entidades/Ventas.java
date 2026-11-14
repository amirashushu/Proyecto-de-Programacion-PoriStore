
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
    private EntregaPedido metodoEntrega;
    private int costoEnvio;
    
    public Ventas(Carro c,int idGenerado, EntregaPedido metodoEntrega, int costoEnvio){
        this.carroVenta = c;
        this.idVenta = idGenerado;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.metodoEntrega = metodoEntrega;
        this.costoEnvio = costoEnvio;
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

    public EntregaPedido getMetodoEntrega() {
        return metodoEntrega;
    }

    public void setMetodoEntrega(EntregaPedido metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public int getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(int costoEnvio) {
        this.costoEnvio = costoEnvio;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
