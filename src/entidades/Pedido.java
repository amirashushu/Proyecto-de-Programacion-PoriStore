/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author Amira
 */
// Pedido que se genera de cada venta confirmada, para seguir su despacho
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int numero;             // Numero unico del pedido
    private final Ventas venta;          
    private final String idCarritoCliente; // id del carrito que pago, para avisarle al cliente los cambios de estado
    private EstadoPedido estado;

    // Pedido nuevo parte en Pendiente
    public Pedido(int numero, Ventas venta, String idCarritoCliente) {
        this.numero = numero;
        this.venta = venta;
        this.idCarritoCliente = idCarritoCliente;
        this.estado = EstadoPedido.Pendiente;
    }

    public int getNumero() {
        return numero;
    }

    public Ventas getVenta() {
        return venta;
    }

    public String getIdCarritoCliente() {
        return idCarritoCliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
