
package vistas;

import java.time.LocalDate;
import logica.SistemaTienda;
import entidades.Cupon;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class CreacionCupones extends BaseFrame {

    
    public CreacionCupones(SistemaTienda st) {
        super(st);
        initComponents();
        this.dispose();
        setVisible(true);
        setLocationRelativeTo(null);
        this.actualizarTabla(st.getCupones());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cmbDescuento = new javax.swing.JComboBox<>();
        lblDescuento = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        lblUsos = new javax.swing.JLabel();
        txtUsos = new javax.swing.JTextField();
        lblVencimiento = new javax.swing.JLabel();
        cmbVencimiento = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCupones = new javax.swing.JTable();
        lblTitulo2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre del cupón: ");

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo1.setText("Cupones creados");

        cmbDescuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5%", "10%", "15%", "20%" }));
        cmbDescuento.addActionListener(this::cmbDescuentoActionPerformed);

        lblDescuento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(255, 255, 255));
        lblDescuento.setText("Descuento Total:");

        btnCrear.setBackground(new java.awt.Color(255, 0, 0));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("Crear Cupón");
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
        });
        btnCrear.addActionListener(this::btnCrearActionPerformed);

        lblUsos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsos.setForeground(new java.awt.Color(255, 255, 255));
        lblUsos.setText("Cantidad de usos:");

        txtUsos.addActionListener(this::txtUsosActionPerformed);

        lblVencimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVencimiento.setForeground(new java.awt.Color(255, 255, 255));
        lblVencimiento.setText("Vencimiento:");

        cmbVencimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1d", "3d", "7d", "14d", "28d" }));
        cmbVencimiento.addActionListener(this::cmbVencimientoActionPerformed);

        tablaCupones.setBackground(new java.awt.Color(0, 0, 0));
        tablaCupones.setForeground(new java.awt.Color(255, 255, 255));
        tablaCupones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dsc total", "Cant. de usos", "Fecha de creación", "Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaCupones);

        lblTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo2.setText("Crear Cupón");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(299, 299, 299))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lblTitulo2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(274, 274, 274)
                                        .addComponent(cmbVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(273, 273, 273)
                                        .addComponent(txtUsos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(273, 273, 273)
                                        .addComponent(cmbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(273, 273, 273)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 6, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(lblTitulo1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDescuentoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtUsosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsosActionPerformed

    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
    
        String codigo = txtNombre.getText().trim();
        String usosTexto = txtUsos.getText().trim();

        if (codigo.isEmpty() || usosTexto.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
       }

        try {
            int usos = Integer.parseInt(usosTexto);
            if (usos <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "La cantidad de usos debe ser mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
        }


        String comboDescuento = cmbDescuento.getSelectedItem().toString().replace("%", "").trim();
        double porcentaje = Double.parseDouble(comboDescuento);
        porcentaje = porcentaje/100;
        String comboVencimiento = cmbVencimiento.getSelectedItem().toString().replace("d", "").trim();
        int dias = Integer.parseInt(comboVencimiento);


        Cupon nuevoCupon = new Cupon(codigo, porcentaje, usos, dias, LocalDate.now());

        if (st.agregarCupon(nuevoCupon)) {
            javax.swing.JOptionPane.showMessageDialog(this, "¡Cupón \"" + codigo.toUpperCase() + "\" creado exitosamente!");

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un cupón con ese nombre.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "La cantidad de usos debe ser un número entero válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }finally{
            actualizarTabla(st.getCupones());
        }
    
    
    }//GEN-LAST:event_btnCrearMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void cmbVencimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVencimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVencimientoActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cmbDescuento;
    private javax.swing.JComboBox<String> cmbVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblUsos;
    private javax.swing.JLabel lblVencimiento;
    private javax.swing.JTable tablaCupones;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsos;
    // End of variables declaration//GEN-END:variables
    public void actualizarTabla(List<Cupon> cupones) {    
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaCupones.getModel();
        modeloTabla.setRowCount(0);
        for ( Cupon c : cupones ) {
            // Cargar imagen en miniatura (60x60)
            modeloTabla.addRow(new Object[]{
                c.getCodigo(),
                c.getPorcentaje()*100+"%",
                c.getUsos(),
                c.getCreacion(),
                c.getVencimiento()
            });
        }
    }
}
