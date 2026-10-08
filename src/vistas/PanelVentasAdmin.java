
package vistas;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import logica.SistemaTienda;

/**
 *
 * @author surfe
 */
public class PanelVentasAdmin extends javax.swing.JPanel {
    private SistemaTienda st;


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
    
    
    tblVentas.setFillsViewportHeight(true);
    
    tblVentas.setFillsViewportHeight(true);
    actualizarTablaVentas();
}
public PanelVentasAdmin() {
    initComponents();
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

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(15, 15, 15));
        jPanel5.setPreferredSize(new java.awt.Dimension(574, 105));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("PoriStore");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/logo.png"))); // NOI18N
        jLabel11.setText("jLabel1");

        jPanel7.setBackground(new java.awt.Color(30, 30, 30));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel7.setPreferredSize(new java.awt.Dimension(250, 80));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 204, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText(Double.toString(st.calcularValorTotalInventario()));

        jLabel25.setForeground(new java.awt.Color(200, 200, 200));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Ventas Totales");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(30, 30, 30));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel8.setPreferredSize(new java.awt.Dimension(250, 80));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Por hacer");

        jLabel28.setForeground(new java.awt.Color(200, 200, 200));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Ganancias");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addGap(57, 57, 57)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(lblMenuProductos)
                .addGap(18, 18, 18)
                .addComponent(lblMenuCarritos)
                .addGap(18, 18, 18)
                .addComponent(lblMenuVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMenuProductos)
                            .addComponent(lblMenuCarritos)
                            .addComponent(lblMenuVentas))
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jPanelVentas.setBackground(new java.awt.Color(0, 0, 0));
        jPanelVentas.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Carritos Activos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N

        jScrollPane1.setToolTipText("");

        tblVentas.setBackground(new java.awt.Color(20, 20, 20));
        tblVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblVentas.setForeground(new java.awt.Color(255, 255, 255));
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "Cliente", "R.U.T", "Fecha", "Productos", "Monto Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane1.setViewportView(tblVentas);
        tblVentas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanelVentasLayout = new javax.swing.GroupLayout(jPanelVentas);
        jPanelVentas.setLayout(jPanelVentasLayout);
        jPanelVentasLayout.setHorizontalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanelVentasLayout.setVerticalGroup(
            jPanelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1592, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    // End of variables declaration//GEN-END:variables

    
    public void actualizarTablaVentas() {
        DefaultTableModel modelo = (DefaultTableModel) tblVentas.getModel();
        modelo.setRowCount(0); //limpiar filas anteriores
        for (entidades.Ventas v : st.getVentas()) {  //recorremos todas las ventas guardadas en el sistema
            entidades.Carro c = v.getCarroVenta();
            String rutCliente = (c.getRun() != null) ? c.getRun() : "Sin RUT";             
            // Si el RUT es nulo (cliente anónimo), mostramos "Sin RUT"
            
            modelo.addRow(new Object[]{
                v.getIdVenta(),                  // ID Venta
                c.getNombre(),                   // Cliente
                rutCliente,                      // R.U.T
                v.getFecha().toString(),         // Fecha (YYYY-MM-DD)
                c.getTotalProductos(),           // El método que le agregamos a Carro!
                c.getTotal()  // Monto Total
            });
        }
        
        actualizarKPIsVentas();
    }

    // 
    private void actualizarKPIsVentas() {  
        double gananciasTotales = 0;
        int cantidadVentas = st.getVentas().size(); //total de ventas realizadas
        for(entidades.Ventas v : st.getVentas()){
            gananciasTotales += v.getCarroVenta().getTotal();
        }
        int gananciasTotalesINT = (int) gananciasTotales;

        jLabel24.setText(String.valueOf(cantidadVentas)); //ventas
        jLabel27.setText("$" + Integer.toString(gananciasTotalesINT));      //monto
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

}

