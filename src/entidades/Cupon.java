/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;


public class Cupon implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private double pDescuento;
    private int uDisponibles;
    private int dVencimiento;
    
    public Cupon(String codigo, double pDescuento, int uDisponibles, int dVencimiento){
        this.codigo = codigo.toUpperCase().trim();
        this.pDescuento = pDescuento;
        this.uDisponibles = uDisponibles;
        this.dVencimiento = dVencimiento;
    } 
    
    public String getCodigo() { return codigo; }
    public double getPorcentajeDescuento() { return pDescuento; }
    public int getUsosDisponibles() { return uDisponibles; }
    
    public boolean esValido() {
        return uDisponibles > 0;
    }
    
    public void usarCupon() {
        if (uDisponibles > 0) {
            uDisponibles--;
     }
    }
}
