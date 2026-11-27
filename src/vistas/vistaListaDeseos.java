/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import entidades.Cliente;
import entidades.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import logica.GestorReserva;
import logica.GestorSesion;
import logica.SistemaTienda;

/**
 *
 * @author Amira
 */
// Ventana con la lista de deseos del cliente, muestra sus favoritos como tarjetas y permite moverlos al carrito o quitarlos
public class vistaListaDeseos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(vistaListaDeseos.class.getName());

    private static final Color FONDO = new Color(20, 20, 20);
    private static final Color ROJO = new Color(180, 0, 0);
    private static final Color GRIS_TEXTO = new Color(170, 170, 170);

    private SistemaTienda st;
    private JLabel lblCantidad;   
    private JPanel panelTarjetas; 

    /**
     * Creates new form vistaListaDeseos
     */
    public vistaListaDeseos() {
        initComponents();
    }

    //muestra la lista del cliente con sesion iniciada
    public vistaListaDeseos(SistemaTienda st, JFrame ventanaOrigen) {
        initComponents();
        this.st = st;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        setResizable(false);
        armarPanel();
        mostrarDeseos();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                mostrarDeseos(); 
            }

            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                if (ventanaOrigen instanceof Carrito) {
                    ((Carrito) ventanaOrigen).cargarDatosCarrito();//por si se movio algo al carrito
                }
            }
        });
    }
    private void armarPanel() {
        Dimension tamano = panelProductos.getSize(); 
        panelProductos.setPreferredSize(tamano);
        panelProductos.setBackground(FONDO);
        panelProductos.setLayout(new BorderLayout(0, 10));
        panelProductos.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));

        lblCantidad = new JLabel();
        lblCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblCantidad.setForeground(GRIS_TEXTO);
        panelProductos.add(lblCantidad, BorderLayout.NORTH);

        panelTarjetas = new JPanel(new GridLayout(0, 4, 12, 12));
        panelTarjetas.setBackground(FONDO);
        JPanel contenedor = new JPanel(new BorderLayout()); 
        contenedor.setBackground(FONDO);
        contenedor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 6));
        contenedor.add(panelTarjetas, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(contenedor);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setBackground(FONDO);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        panelProductos.add(scroll, BorderLayout.CENTER);
    }

    //una tarjeta por cada producto de la lista del cliente
    private void mostrarDeseos() {
        Cliente cliente = GestorSesion.getClienteActual();
        if (cliente == null) {
            return;
        }
        panelTarjetas.removeAll();
        int cantidad = cliente.getListaDeseos().size();
        for (String nombre : cliente.getListaDeseos()) {
            panelTarjetas.add(crearTarjeta(nombre, buscarProducto(nombre)));
        }
        if (cantidad == 0) {
            lblCantidad.setText("Todavía no tienes productos en tu lista. Usa el botón Deseos del catálogo.");
        } else {
            lblCantidad.setText(cantidad == 1 ? "1 producto guardado" : cantidad + " productos guardados");
        }
        panelTarjetas.revalidate();
        panelTarjetas.repaint();
    }

    //aqui se busca el producto actual (null si el admin lo elimino o le cambio el nombre)
    private Producto buscarProducto(String nombre) {
        for (Producto p : st.getProductos()) {
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }
    private JPanel crearTarjeta(String nombre, Producto p) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));
        tarjeta.setBackground(new Color(30, 30, 30));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 0, 0)),
                BorderFactory.createEmptyBorder(10, 5, 8, 5)));

        JLabel imagen = new JLabel("Sin imagen", SwingConstants.CENTER);
        imagen.setForeground(Color.GRAY);
        ImageIcon icono = p != null ? cargarImagen(p.getRutaImagen()) : null;
        if (icono != null) {
            imagen.setText(null);
            imagen.setIcon(icono);
        }
        imagen.setPreferredSize(new Dimension(120, 90));
        imagen.setMaximumSize(new Dimension(120, 90));
        agregarCentrado(tarjeta, imagen);
        agregarCentrado(tarjeta, crearTexto(nombre.toUpperCase(), Font.BOLD, 12, Color.WHITE));

        if (p == null) {
            agregarCentrado(tarjeta, crearTexto("Ya no está disponible", Font.PLAIN, 11, GRIS_TEXTO));
        } else {
            agregarCentrado(tarjeta, crearTexto(SistemaTienda.formatoPesos(p.getPrecio()), Font.BOLD, 13, new Color(255, 50, 50)));
            boolean hayStock = p.getStock() > 0;
            agregarCentrado(tarjeta, crearTexto(hayStock ? "Disponible: " + p.getStock() : "Sin stock", Font.BOLD, 11,
                    hayStock ? new Color(111, 207, 143) : new Color(255, 107, 107)));

            JButton mover = crearBoton("Mover al carrito", hayStock ? ROJO : new Color(51, 51, 51));
            mover.addActionListener(e -> moverAlCarrito(p));
            agregarCentrado(tarjeta, mover);
        }

        JButton quitar = crearBoton("Quitar", new Color(30, 30, 30));
        quitar.setForeground(GRIS_TEXTO);
        quitar.addActionListener(e -> quitar(nombre));
        agregarCentrado(tarjeta, quitar);
        return tarjeta;
    }

    private void agregarCentrado(JPanel tarjeta, javax.swing.JComponent componente) {
        componente.setAlignmentX(Component.CENTER_ALIGNMENT);
        tarjeta.add(componente);
        tarjeta.add(Box.createVerticalStrut(6));
    }

    private JLabel crearTexto(String texto, int estilo, int tamano, Color color) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("Segoe UI", estilo, tamano));
        etiqueta.setForeground(color);
        return etiqueta;
    }

    private JButton crearBoton(String texto, Color fondo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 10));
        boton.setBackground(fondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        return boton;
    }

    private ImageIcon cargarImagen(String ruta) {
        if (ruta == null || ruta.trim().isEmpty()) {
            return null;
        }
        String rutaRecurso = ruta.trim().startsWith("/") ? ruta.trim() : "/" + ruta.trim();
        Image img = null;
        java.net.URL url = getClass().getResource(rutaRecurso);
        if (url != null) {
            img = new ImageIcon(url).getImage();
        } else {
            java.io.File archivo = new java.io.File("src" + rutaRecurso);
            if (archivo.exists()) {
                img = new ImageIcon(archivo.getAbsolutePath()).getImage();
            }
        }
        return img == null ? null : new ImageIcon(img.getScaledInstance(120, 90, Image.SCALE_SMOOTH));
    }
    //agrega 1 unidad con la misma validacion de stock del carrito, y lo saca de la lista
    private void moverAlCarrito(Producto p) {
        if (!st.obtenerCarritoActual().agregarProCarrito(p, 1)) {
            JOptionPane.showMessageDialog(this, "\"" + p.getNombre() + "\" no tiene stock disponible.", "Sin stock", JOptionPane.WARNING_MESSAGE);
            return;
        }
        GestorSesion.getClienteActual().quitarDeDeseos(p.getNombre());
        st.guardarDatos();
        GestorReserva.iniciar(st.obtenerCarritoActual(), st); //empieza el tiempo de reserva, igual que al usar "Agregar"
        mostrarDeseos();
        JOptionPane.showMessageDialog(this, p.getNombre() + " se movió a tu carrito.");
    }

    private void quitar(String nombre) {
        GestorSesion.getClienteActual().quitarDeDeseos(nombre);
        st.guardarDatos();
        mostrarDeseos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labeltitulo = new javax.swing.JLabel();
        panelProductos = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        labeltitulo.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        labeltitulo.setForeground(new java.awt.Color(255, 255, 255));
        labeltitulo.setText("Mi lista de deseos");

        panelProductos.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 51));

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(170, 170, 170));
        jLabel1.setText("Tus productos favoritos, listos para cuando quieras");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeltitulo)
                            .addComponent(jLabel1))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labeltitulo))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelProductos;
    // End of variables declaration//GEN-END:variables
}
