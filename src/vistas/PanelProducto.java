package vistas;

import entidades.Producto;
import javax.swing.*;
import java.awt.*;

public class PanelProducto extends JPanel {

public PanelProducto(Producto p) {
    // CONFIGURACIÓN DEL PANEL
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBackground(new Color(30, 30, 30));
    this.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 1));
    this.setPreferredSize(new Dimension(160, 210));

    // DECLARACIÓN GENERAL DE COMPONENTES (Para que sirvan en todo el método)
    JLabel lblImagen = new JLabel();
    JLabel lblNombre;
    JLabel lblPrecio;
    JButton btnAgregar = new JButton("Agregar");

    // IMGAEN
    lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
    boolean imagenCargada = false;

    if (p.getRutaImagen() != null && !p.getRutaImagen().trim().isEmpty()) {
        try {
            java.io.File file = new java.io.File(p.getRutaImagen());
            if (file.exists()) {
                ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(img));
                imagenCargada = true;
            }
        } catch (Exception e) {
            imagenCargada = false;
        }
    }
    if (!imagenCargada) {
        lblImagen.setText("Sin Imagen");
        lblImagen.setForeground(Color.GRAY);
    }

    // NOMBRE
    String textoNombre = (p.getNombre() != null && !p.getNombre().isEmpty()) ? p.getNombre().toUpperCase() : "PRODUCTO";
    lblNombre = new JLabel(textoNombre);
    lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 12));
    lblNombre.setForeground(Color.WHITE);
    lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

    // PRECIO
    lblPrecio = new JLabel("$" + String.format("%.0f", p.getPrecio()));
    lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 13));
    lblPrecio.setForeground(new Color(255, 50, 50));
    lblPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);

    // BOTON
    btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 10));
    btnAgregar.setBackground(new Color(180, 0, 0));
    btnAgregar.setForeground(Color.WHITE);
    btnAgregar.setFocusPainted(false);
    btnAgregar.setAlignmentX(Component.CENTER_ALIGNMENT);

    // TARJETA
    add(Box.createVerticalStrut(10));
    add(lblImagen);
    add(Box.createVerticalStrut(10));
    add(lblNombre);
    add(Box.createVerticalStrut(10));
    add(lblPrecio);
    add(Box.createVerticalStrut(10));
    add(btnAgregar);
    add(Box.createVerticalStrut(10));
    }
}