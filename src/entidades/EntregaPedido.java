package entidades;

import java.io.Serializable;

public class EntregaPedido implements Serializable{
    private String metodoEntrega;
    private String región;
    private String ciudad;
    private String calle;
    private String numero;
    private String cel;
    private String comentarios;
    private int costoEnvio;
    public EntregaPedido(String metodoEntrega, String región, String ciudad, String calle, String numero, String cel, String comentarios){
        this.metodoEntrega = metodoEntrega;
        this.región = región;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.cel = cel;
        this.comentarios = comentarios;
        this.costoEnvio = 0;  //FALTA LO DE CALCULAR EL COSTO DE ENVIO
    }

    public String getMetodoEntrega() {
        return metodoEntrega;
    }

    public void setMetodoEntrega(String metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public String getRegión() {
        return región;
    }

    public void setRegión(String región) {
        this.región = región;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public int getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(int costoEnvio) {
        this.costoEnvio = costoEnvio;
    }
    
    
    
    
    
    
    
    
    
}
