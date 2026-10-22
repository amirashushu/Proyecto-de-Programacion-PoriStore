
package vistas;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import logica.SistemaTienda;

/**
 *
 * @author surfe
 */
public class PanelVentasAdmin extends javax.swing.JPanel {
    private SistemaTienda st;
    private TableRowSorter<DefaultTableModel> filtroVentas;


    public PanelVentasAdmin(SistemaTienda st) {
        this.st = st;

        initComponents();


        jPanelVentas.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            null, 
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), 
                javax.swing.BorderFactory.createTitledBorder(
                    javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), 
                    "Ventas", 
                    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                    javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                    new java.awt.Font("Segoe UI", 1, 18), 
                    new java.awt.Color(255, 0, 51)
                )
            )
        ));


        jScrollPane1.setBackground(new java.awt.Color(20, 20, 20));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(20, 20, 20));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 60, 60)));


        tblVentas.getTableHeader().setBackground(new java.awt.Color(180, 0, 0));
        tblVentas.getTableHeader().setForeground(java.awt.Color.WHITE);
        tblVentas.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tblVentas.getTableHeader().setReorderingAllowed(false);

        ordenarColumna();
        configurarBusquedaPorRut();
        tblVentas.setFillsViewportHeight(true);

        tblVentas.setFillsViewportHeight(true);
        actualizarTablaVentas();
    }
    public PanelVentasAdmin() {
        initComponents();
        
        
        // Evento al hacer clic en el botón Buscar
    btnBuscar.addActionListener(e -> ejecutarBusquedaCliente());

    // Búsqueda automática mientras se escribe en el cuadro de texto
    txtBuscar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    @Override
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        ejecutarBusquedaCliente();
    }
    @Override
    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        ejecutarBusquedaCliente();
    }
    @Override
    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        ejecutarBusquedaCliente();
    }
});
    

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblMenuProductos = new javax.swing.JLabel();
        lblMenuCarritos = new javax.swing.JLabel();
        lblMenuVentas = new javax.swing.JLabel();
        jPanelVentas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarRut = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(15, 15, 15));
        jPanel5.setPreferredSize(new java.awt.Dimension(1200, 105));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("PoriStore");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/logo.png"))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(30, 30, 30));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel7.setPreferredSize(new java.awt.Dimension(210, 80));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("0");

        jLabel25.setForeground(new java.awt.Color(200, 200, 200));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Ventas Totales");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel25, 0, 192, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(19, 19, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(30, 30, 30));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel8.setPreferredSize(new java.awt.Dimension(210, 80));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 200, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("$0");

        jLabel28.setForeground(new java.awt.Color(200, 200, 200));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Ganancias");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addGap(19, 19, Short.MAX_VALUE))
        );

        lblMenuProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuProductos.setText("Productos");

        lblMenuCarritos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuCarritos.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuCarritos.setText("Carritos Activos");

        lblMenuVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuVentas.setText("Ventas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblMenuProductos)
                .addGap(12, 12, 12)
                .addComponent(lblMenuCarritos)
                .addGap(12, 12, 12)
                .addComponent(lblMenuVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenuProductos)
                    .addComponent(lblMenuCarritos)
                    .addComponent(lblMenuVentas)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelVentas.setBackground(new java.awt.Color(0, 0, 0));
        jPanelVentas.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N

        jScrollPane1.setToolTipText("");

        tblVentas.setBackground(new java.awt.Color(20, 20, 20));
        tblVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblVentas.setForeground(new java.awt.Color(255, 255, 255));
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venta", "Cliente", "R.U.T", "Fecha", "Hora", "Productos", "Monto Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVentas.setColumnSelectionAllowed(true);
        tblVentas.setGridColor(new java.awt.Color(60, 60, 60));
        tblVentas.setRowHeight(30);
        tblVentas.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblVentas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVentas);
        tblVentas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanelVentasLayout = new javax.swing.GroupLayout(jPanelVentas);
        jPanelVentas.setLayout(jPanelVentasLayout);
        jPanelVentasLayout.setHorizontalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelVentasLayout.setVerticalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por RUT:");

        txtBuscarRut.setBackground(new java.awt.Color(30, 30, 30));
        txtBuscarRut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarRut.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscarRut.setCaretColor(new java.awt.Color(255, 0, 51));
        txtBuscarRut.setPreferredSize(new java.awt.Dimension(260, 30));

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        btnBuscar.setBackground(new java.awt.Color(204, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar Por Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarRut, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelVentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarRut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jPanelVentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ejecutarBusquedaCliente();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMenuCarritos;
    private javax.swing.JLabel lblMenuProductos;
    private javax.swing.JLabel lblMenuVentas;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarRut;
    // End of variables declaration//GEN-END:variables

    
    public void actualizarTablaVentas() {
    actualizarTablaVentas(st.getVentas());
    }

    // 
    private void actualizarKPIsVentas() {  
        double gananciasTotales = 0;
        int cantidadVentas = st.getVentas().size(); //total de ventas realizadas
        for(entidades.Ventas v : st.getVentas()){
            gananciasTotales += v.getCarroVenta().getSubTotal() ;
        }
        int gananciasTotalesINT = (int) gananciasTotales;

        Locale localeCl = Locale.of("es", "CL");  //formato chileno
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(localeCl);
        String montoFormateado = formatoMoneda.format(gananciasTotalesINT);
        jLabel24.setText(String.valueOf(cantidadVentas)); //ventas
        jLabel27.setText(montoFormateado);      //monto
    }
    private void ordenarColumna() {
        // Permite ordenar columnas y filtrar sin modificar los datos originales
        filtroVentas = new TableRowSorter<>((DefaultTableModel) tblVentas.getModel());
        tblVentas.setRowSorter(filtroVentas);
    }

    private void configurarBusquedaPorRut() {
        txtBuscarRut.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filtrarVentasPorRut();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filtrarVentasPorRut();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filtrarVentasPorRut();
            }
        });
    }

    private void filtrarVentasPorRut() {
        if (filtroVentas == null) return;
        // Compara solo los números; permite escribir con o sin puntos y guion
        String buscado = txtBuscarRut.getText().replaceAll("[^0-9kK]", "").toLowerCase();
        if (buscado.isEmpty()) {
            filtroVentas.setRowFilter(null);
        } else {
            filtroVentas.setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
                @Override
                public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entrada) {
                    String rut = String.valueOf(entrada.getValue(2));
                    rut = rut.replaceAll("[^0-9kK]", "").toLowerCase();
                    return rut.contains(buscado);
                }
            });
        }
    }
    public javax.swing.JLabel getMenuProductos() {
        return lblMenuProductos;
    }

    public javax.swing.JLabel getMenuCarritos() {
        return lblMenuCarritos;
    }

    public javax.swing.JLabel getMenuVentas() {
        return lblMenuVentas;
    }

    public javax.swing.JPanel getHeader() {
        return jPanel5; 
    }

    public javax.swing.JLabel getLogo() {
        return jLabel11; 
    }

    public javax.swing.JLabel getTitulo() {
        return jLabel10; 
    }
    public javax.swing.JPanel getPanelPrincipal() {
        return this; 
    }

    
    
   
public void actualizarTablaVentas(java.util.List<entidades.Ventas> listaVentas) {
    DefaultTableModel modelo = (DefaultTableModel) tblVentas.getModel();
    modelo.setRowCount(0);
    java.text.NumberFormat formatoCLP = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("es", "CL"));

    for (entidades.Ventas v : listaVentas) {
        if (v.getCarroVenta() == null) continue;

        // Formatear la fecha y hora usando los getters correspondientes
        String fecha = (v.getFecha() != null) ? v.getFecha().toString() : "-";
        if (v.getHora() != null) {
            fecha += " " + v.getHora().toString().substring(0, 5); // Agrega HH:mm
        }

        String rut = v.getCarroVenta().getRun();
        String cliente = v.getCarroVenta().getNombre();
        
        StringBuilder productosStr = new StringBuilder();
        for (java.util.Map.Entry<entidades.Producto, Integer> entry : v.getCarroVenta().getCarritoProductos().entrySet()) {
            if (productosStr.length() > 0) productosStr.append(", ");
            productosStr.append(entry.getKey().getNombre()).append(" x").append(entry.getValue());
        }

        double total = v.getCarroVenta().getTotal();

        modelo.addRow(new Object[]{
            v.getIdVenta(),
            rut,
            cliente,
            fecha,
            productosStr.toString(),
            formatoCLP.format(total)
        });
    }
}

private void ejecutarBusquedaCliente() {
    String criterio = txtBuscar.getText().trim();
    actualizarTablaVentas(st.buscarVentasPorCliente(criterio));
}

}

