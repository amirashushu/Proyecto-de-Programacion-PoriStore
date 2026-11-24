
package vistas;
import entidades.Producto;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logica.SistemaTienda;

/**
 *
 * @author surfe
 */
public class VistaCategorias extends BaseFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaCategorias.class.getName());

    /**
     * Creates new form VistaCategorias
     */
    public VistaCategorias(SistemaTienda st) {
    super(st);
    initComponents();
    setLocationRelativeTo(null);
    jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
    cargarProductosPorCategoria();

    
    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    for (java.awt.event.WindowListener wl : getWindowListeners()) {
        removeWindowListener(wl);
    }
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            VistaPrincipal inicio = new VistaPrincipal(st);
            inicio.setVisible(true);
            dispose();
        }
    });
}
    
    private void cargarProductosPorCategoria() {
    contenedorCategorias.removeAll();
    contenedorCategorias.setBorder(BorderFactory.createEmptyBorder(20, 25, 25, 25));

    if (st == null || st.getProductos() == null || st.getProductos().isEmpty()) {
        JLabel lblVacio = new JLabel("No hay productos disponibles en el catálogo.");
        lblVacio.setForeground(Color.GRAY);
        lblVacio.setFont(new Font("Segoe UI", Font.BOLD, 16));
        contenedorCategorias.add(lblVacio);
        return;
    }

    // agrupa los productos segun la categoria
    Map<String, List<Producto>> mapaCategorias = new LinkedHashMap<>();
    for (Producto p : st.getProductos()) {
        String cat = (p.getCategoria() != null && !String.valueOf(p.getCategoria()).trim().isEmpty())
        ? String.valueOf(p.getCategoria()).trim()
        : "Sin Categoría";
        mapaCategorias.computeIfAbsent(cat, k -> new ArrayList<>()).add(p);
    }

    
    for (Map.Entry<String, List<Producto>> entrada : mapaCategorias.entrySet()) {
        JPanel panelTituloCat = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        panelTituloCat.setBackground(new Color(15, 15, 15));
        panelTituloCat.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblTituloCat = new JLabel("  " + entrada.getKey().toUpperCase());
        lblTituloCat.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTituloCat.setForeground(Color.WHITE);
        lblTituloCat.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0, new Color(255, 0, 51)));
        panelTituloCat.add(lblTituloCat);

        contenedorCategorias.add(panelTituloCat);
        contenedorCategorias.add(Box.createVerticalStrut(10));

        JPanel panelTarjetas = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        panelTarjetas.setBackground(new Color(22, 22, 22));
        panelTarjetas.setBorder(BorderFactory.createLineBorder(new Color(45, 45, 45), 1));
        panelTarjetas.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (Producto p : entrada.getValue()) {
            panelTarjetas.add(crearTarjetaProducto(p));
        }

        contenedorCategorias.add(panelTarjetas);
        contenedorCategorias.add(Box.createVerticalStrut(25));
    }

    contenedorCategorias.revalidate();
    contenedorCategorias.repaint();
}

private JPanel crearTarjetaProducto(Producto p) {
    JPanel card = new JPanel();
    card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
    card.setBackground(new Color(30, 30, 30));
    card.setOpaque(true);
    card.setBorder(BorderFactory.createLineBorder(new Color(200, 0, 0), 1));
    card.setPreferredSize(new Dimension(160, 210));
    card.setMaximumSize(new Dimension(160, 210));

    JLabel lblImagen = new JLabel();
    lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
    boolean imagenCargada = false;

    if (p.getRutaImagen() != null && !p.getRutaImagen().trim().isEmpty()) {
        try {
            String ruta = p.getRutaImagen().trim();
            String rutaRecurso = ruta.startsWith("/") ? ruta : "/" + ruta;
            URL url = getClass().getResource(rutaRecurso);
            Image img = null;
            if (url != null) {
                img = new ImageIcon(url).getImage();
            } else {
                File file = new File("src" + rutaRecurso);
                if (file.exists()) {
                    img = new ImageIcon(file.getAbsolutePath()).getImage();
                }
            }
            if (img != null) {
                lblImagen.setIcon(new ImageIcon(img.getScaledInstance(120, 90, Image.SCALE_SMOOTH)));
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

    String textoNombre = (p.getNombre() != null && !p.getNombre().isEmpty()) ? p.getNombre().toUpperCase() : "PRODUCTO";
    JLabel lblNombre = new JLabel(textoNombre);
    lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 12));
    lblNombre.setForeground(Color.WHITE);
    lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel lblPrecio = new JLabel(SistemaTienda.formatoPesos(p.getPrecio()));
    lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 13));
    lblPrecio.setForeground(new Color(255, 50, 50));
    lblPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton btnAgregar = new JButton("Agregar");
    btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 10));
    btnAgregar.setBackground(new Color(180, 0, 0));
    btnAgregar.setForeground(Color.WHITE);
    btnAgregar.setFocusPainted(false);
    btnAgregar.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnAgregar.addActionListener(e -> agregarAlCarrito(p));

    card.add(Box.createVerticalStrut(10));
    card.add(lblImagen);
    card.add(Box.createVerticalStrut(10));
    card.add(lblNombre);
    card.add(Box.createVerticalStrut(10));
    card.add(lblPrecio);
    card.add(Box.createVerticalStrut(10));
    card.add(btnAgregar);
    card.add(Box.createVerticalStrut(10));

    return card;
}

private void agregarAlCarrito(Producto p) {
    if (p.getStock() <= 0) {
        JOptionPane.showMessageDialog(this, "\"" + p.getNombre() + "\" no tiene stock disponible.", "Sin stock", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String texto = JOptionPane.showInputDialog(this, "¿Cuántas unidades de " + p.getNombre() + "? (disponibles: " + p.getStock() + ")", "1");
    if (texto == null) {
        return;
    }
    try {
        int cantidad = Integer.parseInt(texto.trim());
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (st.obtenerCarritoActual().agregarProCarrito(p, cantidad)) {
            st.guardarDatos();
            JOptionPane.showMessageDialog(this, "Agregado al carrito: " + p.getNombre() + " x" + cantidad);
        } else {
            JOptionPane.showMessageDialog(this, "No hay stock suficiente (disponibles: " + p.getStock() + ").", "Sin stock", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicio2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LblJoin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Banner = new PanelImagen("/fotos/banner.png");
        lblBannerTitulo = new javax.swing.JLabel();
        lblBannerSubtitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        contenedorCategorias = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelInicio2.setBackground(new java.awt.Color(0, 0, 0));
        panelInicio2.setPreferredSize(new java.awt.Dimension(1280, 960));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/carro.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/logo.png"))); // NOI18N
        jLabel4.setText("jLabel1");

        LblJoin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/user.png"))); // NOI18N
        LblJoin.setText("jLabel1");
        LblJoin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LblJoin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblJoinMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("PoriStore");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Inicio");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categorías");

        lblBannerTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblBannerTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblBannerTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblBannerTitulo.setText("CATEGORIAS DE PRODUCTOS");

        lblBannerSubtitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblBannerSubtitulo.setForeground(new java.awt.Color(220, 220, 220));
        lblBannerSubtitulo.setText("Armas, polvitos magicos y yerbas medicinales al mejor precio");

        javax.swing.GroupLayout BannerLayout = new javax.swing.GroupLayout(Banner);
        Banner.setLayout(BannerLayout);
        BannerLayout.setHorizontalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBannerSubtitulo)
                    .addComponent(lblBannerTitulo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BannerLayout.setVerticalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblBannerTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBannerSubtitulo)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        contenedorCategorias.setBackground(new java.awt.Color(0, 0, 0));
        contenedorCategorias.setLayout(new javax.swing.BoxLayout(contenedorCategorias, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(contenedorCategorias);

        javax.swing.GroupLayout panelInicio2Layout = new javax.swing.GroupLayout(panelInicio2);
        panelInicio2.setLayout(panelInicio2Layout);
        panelInicio2Layout.setHorizontalGroup(
            panelInicio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicio2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(251, 251, 251)
                .addComponent(jLabel6)
                .addGap(155, 155, 155)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(panelInicio2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Banner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelInicio2Layout.setVerticalGroup(
            panelInicio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicio2Layout.createSequentialGroup()
                .addGroup(panelInicio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicio2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelInicio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInicio2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelInicio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Banner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelInicio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicio2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        Carrito vistaCarrito = new Carrito(st);
        vistaCarrito.setVisible(true);
        this.dispose();
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void LblJoinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblJoinMouseClicked
        // Si no hay sesión activa, abrir login
        if (!logica.GestorSesion.haySesionActiva()) {
            VistaLogin login = new VistaLogin(st);
            this.dispose();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } else {
            // Si ya hay sesión, abre "Mi Perfil"
            VistaPerfil perfil = new VistaPerfil(st, this);
            perfil.setVisible(true);
        }
    }//GEN-LAST:event_LblJoinMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        VistaPrincipal vistaInicio = new VistaPrincipal(st);
        vistaInicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Banner;
    private javax.swing.JLabel LblJoin;
    private javax.swing.JPanel contenedorCategorias;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBannerSubtitulo;
    private javax.swing.JLabel lblBannerTitulo;
    private javax.swing.JPanel panelInicio2;
    // End of variables declaration//GEN-END:variables
}
