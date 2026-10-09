package vistas;

import entidades.Carro;
import entidades.Producto;
import entidades.Ventas;
import logica.SistemaTienda;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author HUGO
 */
public class Carrito extends BaseFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Carrito.class.getName());

    public Carrito(SistemaTienda st) {
        super(st);
        initComponents();
        setLocationRelativeTo(null);
        configurarTabla();
        cargarDatosCarrito();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tblCarrito = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnCambiarCantidad = new javax.swing.JButton();
        btnVaciar = new javax.swing.JButton();
        panelResumen = new javax.swing.JPanel();
        lblTituloResumen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblSubtotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblIvaTexto = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        lblSubtotalTexto = new javax.swing.JLabel();
        lblIva1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTotalText = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCantidadProductos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 960));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/logo.png"))); // NOI18N
        jLabel2.setText("jLabel1");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/user.png"))); // NOI18N
        jLabel3.setText("jLabel1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("PoriStore");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

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

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Volver");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/carroSeleccion.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        tblCarrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        jTable1.setBackground(new java.awt.Color(30, 30, 30));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(44, 44, 44));
        jTable1.setRowHeight(32);
        jTable1.setSelectionBackground(new java.awt.Color(180, 0, 0));
        tblCarrito.setViewportView(jTable1);

        btnEliminar.setBackground(new java.awt.Color(180, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar producto");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnCambiarCantidad.setBackground(new java.awt.Color(180, 0, 0));
        btnCambiarCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCambiarCantidad.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarCantidad.setText("Cambiar cantidad");
        btnCambiarCantidad.setBorderPainted(false);
        btnCambiarCantidad.setFocusPainted(false);
        btnCambiarCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarCantidadMouseClicked(evt);
            }
        });
        btnCambiarCantidad.addActionListener(this::btnCambiarCantidadActionPerformed);

        btnVaciar.setBackground(new java.awt.Color(0, 0, 0));
        btnVaciar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVaciar.setForeground(new java.awt.Color(255, 100, 100));
        btnVaciar.setText("Vaciar Carrito");
        btnVaciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 0, 0)));
        btnVaciar.setFocusPainted(false);
        btnVaciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVaciarMouseClicked(evt);
            }
        });

        panelResumen.setBackground(new java.awt.Color(30, 30, 30));
        panelResumen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));

        lblTituloResumen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloResumen.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloResumen.setText("Resumen");

        jSeparator1.setForeground(new java.awt.Color(60, 60, 60));

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(204, 204, 204));
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText(String.valueOf(st.obtenerCarritoActual().getTotal()));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText(String.valueOf(st.obtenerCarritoActual().getTotal()) );

        lblIvaTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIvaTexto.setForeground(new java.awt.Color(204, 204, 204));
        lblIvaTexto.setText("IVA (19%): ");

        btnPagar.setBackground(new java.awt.Color(180, 0, 0));
        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.setBorderPainted(false);
        btnPagar.setFocusPainted(false);
        btnPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarMouseClicked(evt);
            }
        });
        btnPagar.addActionListener(this::btnPagarActionPerformed);

        lblSubtotalTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtotalTexto.setForeground(new java.awt.Color(204, 204, 204));
        lblSubtotalTexto.setText("Subtotal:");

        lblIva1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIva1.setForeground(new java.awt.Color(204, 204, 204));
        lblIva1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIva1.setText(String.valueOf(st.obtenerCarritoActual().getIVA()) );

        jSeparator2.setForeground(new java.awt.Color(60, 60, 60));

        lblTotalText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotalText.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalText.setText("Total:");

        javax.swing.GroupLayout panelResumenLayout = new javax.swing.GroupLayout(panelResumen);
        panelResumen.setLayout(panelResumenLayout);
        panelResumenLayout.setHorizontalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(lblTituloResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addComponent(lblSubtotalTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubtotal))
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addComponent(lblIvaTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIva1))
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addComponent(lblTotalText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResumenLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        panelResumenLayout.setVerticalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtotal)
                    .addComponent(lblSubtotalTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIvaTexto)
                    .addComponent(lblIva1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotalText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Tu carrito");

        lblCantidadProductos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblCantidadProductos.setForeground(new java.awt.Color(153, 153, 153));
        lblCantidadProductos.setText("0 productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(328, 328, 328)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantidadProductos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCambiarCantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVaciar))
                            .addComponent(tblCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(panelResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCambiarCantidad, btnEliminar, btnVaciar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblCantidadProductos))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tblCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnVaciar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCambiarCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCambiarCantidad, btnEliminar, btnVaciar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        VistaPrincipal principal = new VistaPrincipal(st);
        principal.setVisible(true);
        this.dispose();
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        VistaPrincipal main = new VistaPrincipal(st);
        this.dispose();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        VistaPrincipal vista = new VistaPrincipal(st);
        this.dispose();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowClosing

    private void btnCambiarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCantidadActionPerformed
        //cambiar la cantidad del producto seleccionado
    }//GEN-LAST:event_btnCambiarCantidadActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        //confirmar la compra y mostrar el comprobante
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        int fila = jTable1.getSelectedRow();
        if(fila != -1){
            int id = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
            String nombreProducto = jTable1.getValueAt(fila, 1).toString();
            int opcion = JOptionPane.showConfirmDialog(null,"¿Desea eliminar " + nombreProducto + " de su carrito?","Eliminar producto",JOptionPane.YES_NO_OPTION);
            if (opcion == 0){
                st.obtenerCarritoActual().eliminarProductoCarrito(id);
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito!.");
            }
            
            cargarDatosCarrito();
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnCambiarCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarCantidadMouseClicked

        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            int idProductoSeleccionado = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
            HashMap<Producto, Integer> p = st.obtenerCarritoActual().getCarritoProductos();
            Map.Entry<Producto, Integer> entrada = p.entrySet().stream()
                .filter(e -> e.getKey().getId() == idProductoSeleccionado)
                .findFirst()
                .orElse(null);
            
            if (entrada == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el producto en el carrito.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Producto pro = entrada.getKey();
            int cantidadActual = entrada.getValue(); 
            int stockEnTienda = pro.getStock();     
            int stockMaximoElegible = stockEnTienda + cantidadActual; 

            if (stockMaximoElegible <= 0) {
                JOptionPane.showMessageDialog(this, "Error con el stock de este producto.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] opcionesCantidad = new String[stockMaximoElegible];
                for (int i = 0; i < stockMaximoElegible; i++) {
                    opcionesCantidad[i] = String.valueOf(i + 1);
                }
                Object seleccion = JOptionPane.showInputDialog(
                    this,
                    "Modificar cantidad para: " + pro.getNombre() + "\n(Máximo disponible: " + stockMaximoElegible + ")",
                    "Cambiar Cantidad",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesCantidad,
                    String.valueOf(cantidadActual) 
                );
                if (seleccion != null) {
                    int nuevaCantidad = Integer.parseInt((String) seleccion);
                    if (nuevaCantidad != cantidadActual) {
                        st.obtenerCarritoActual().actualizarCantidad(pro.getId(), nuevaCantidad);
                        JOptionPane.showMessageDialog(this, "Cantidad actualizada a " + nuevaCantidad + " unidades.");
                    }
            }
        }
        cargarDatosCarrito();
    }
    }//GEN-LAST:event_btnCambiarCantidadMouseClicked

    private void btnVaciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVaciarMouseClicked
    HashMap<Producto, Integer> carritoProductos = st.obtenerCarritoActual().getCarritoProductos();
    if (carritoProductos == null || carritoProductos.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El carrito ya está vacío.", "Información", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    int confirmacion = JOptionPane.showConfirmDialog(
        this, 
        "¿Estás seguro de que deseas vaciar todo el carrito?", 
        "Confirmar Vaciar Carrito", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.WARNING_MESSAGE
    );
    if (confirmacion == JOptionPane.YES_OPTION) {
        st.obtenerCarritoActual().vaciarCarrito();
        JOptionPane.showMessageDialog(this, "Se ha vaciado el carrito correctamente.");
        cargarDatosCarrito();
        }
    }//GEN-LAST:event_btnVaciarMouseClicked

    private void btnPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagarMouseClicked
         
        Carro carrito = st.obtenerCarritoActual();
        if(carrito.getCarritoProductos().isEmpty()){
            JOptionPane.showMessageDialog(this, "El carrito está vacío, porfavor agregue productos", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Abre el pago simulado con tarjeta, si se aprueba registra la venta y muestra el comprobante
        setEnabled(false); // el carrito queda bloqueado mientras está abierta la ventana de pago
        VistaPago pago = new VistaPago(carrito, () -> {
            st.confirmarCompra(carrito);
            st.guardarDatos();
        }, () -> {
            setEnabled(true);
            cargarDatosCarrito();
            toFront();
        });
        pago.setLocationRelativeTo(this);
        pago.setVisible(true);
        
    }//GEN-LAST:event_btnPagarMouseClicked

    // Estilo de la tabla
    private void configurarTabla() {
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);

        // Cabecera roja con texto blanco
        JTableHeader cabecera = jTable1.getTableHeader();
        cabecera.setBackground(new Color(180, 0, 0));
        cabecera.setForeground(Color.WHITE);
        cabecera.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // ID y cantidad centrados, precios a la derecha
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centro);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centro);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(derecha);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(derecha);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarCantidad;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCantidadProductos;
    private javax.swing.JLabel lblIva1;
    private javax.swing.JLabel lblIvaTexto;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblSubtotalTexto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloResumen;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalText;
    private javax.swing.JPanel panelResumen;
    private javax.swing.JScrollPane tblCarrito;
    // End of variables declaration//GEN-END:variables
    private void cargarDatosCarrito() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        entidades.Carro carro = st.obtenerCarritoActual();
        int cantidadTotalProductos = 0;
        for (java.util.Map.Entry<entidades.Producto, Integer> entry : carro.getCarritoProductos().entrySet()) {
            entidades.Producto p = entry.getKey();
            int cantidad = entry.getValue();
            double subtotalItem = p.getPrecio() * cantidad;

            modelo.addRow(new Object[]{p.getId(), p.getNombre(), String.format("$%.0f", p.getPrecio()), cantidad, String.format("$%.0f", subtotalItem)});
            cantidadTotalProductos += cantidad;
        }
        //Actualiza textos
        lblCantidadProductos.setText(cantidadTotalProductos + " productos");
        lblSubtotal.setText(String.format("$%.0f", carro.getSubTotal()));
        lblIva1.setText(String.format("$%.0f", carro.getIVA()));
        lblTotal.setText(String.format("$%.0f", carro.getTotal()));
    }

}
