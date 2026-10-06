package vistas;

import entidades.Carro;
import entidades.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.SistemaTienda;

// Vista del admin, carritos activos de los clientes y stock disponible/reservado de cada producto
public final class PanelCarritosAdmin extends BaseFrame {

    private final DefaultTableModel modeloCarritos;
    private final DefaultTableModel modeloInventario;
    private final NumberFormat formatoCLP = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CL"));
    //Refresca los datos cada 2 segundos para ver los cambios casi al instante
    private final Timer timerActualizar;

    public PanelCarritosAdmin(SistemaTienda st) {
        super(st);
        initComponents();
        this.setLocationRelativeTo(null);
        this.modeloCarritos = (DefaultTableModel) tblCarritos.getModel();
        this.modeloInventario = (DefaultTableModel) tblInventario.getModel();
        configurarTablas();
        actualizarDatos();
        timerActualizar = new Timer(2000, e -> actualizarDatos());
        timerActualizar.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        PanelPrincipal = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        CarritosActivos = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        UnidadesReservadas = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        TotalEnCarritos = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblMenuCarritos = new javax.swing.JLabel();
        lblMenuProductos = new javax.swing.JLabel();
        jPanelCarritos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarritos = new javax.swing.JTable();
        jPanelnventario = new javax.swing.JPanel();
        jScrollPanel2 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("PoriStore");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/logo.png"))); // NOI18N
        jLabel8.setText("jLabel1");

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

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        PanelPrincipal.setPreferredSize(new java.awt.Dimension(1400, 800));

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

        jPanel6.setBackground(new java.awt.Color(30, 30, 30));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel6.setPreferredSize(new java.awt.Dimension(250, 80));

        CarritosActivos.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        CarritosActivos.setForeground(new java.awt.Color(255, 255, 255));
        CarritosActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CarritosActivos.setText(Integer.toString(st.calcularTotalProductos()));

        jLabel23.setForeground(new java.awt.Color(200, 200, 200));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Carritos activos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CarritosActivos, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarritosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(30, 30, 30));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel7.setPreferredSize(new java.awt.Dimension(250, 80));

        UnidadesReservadas.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        UnidadesReservadas.setForeground(new java.awt.Color(255, 0, 51));
        UnidadesReservadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UnidadesReservadas.setText(Double.toString(st.calcularValorTotalInventario()));

        jLabel25.setForeground(new java.awt.Color(200, 200, 200));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Unidades reservadas");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(UnidadesReservadas, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UnidadesReservadas)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(30, 30, 30));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel8.setPreferredSize(new java.awt.Dimension(250, 80));

        TotalEnCarritos.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        TotalEnCarritos.setForeground(new java.awt.Color(255, 200, 0));
        TotalEnCarritos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalEnCarritos.setText("Por hacer");

        jLabel28.setForeground(new java.awt.Color(200, 200, 200));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Total en carritos");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalEnCarritos, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalEnCarritos)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblMenuCarritos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuCarritos.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuCarritos.setText("Carritos Activos");

        lblMenuProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuProductos.setText("Productos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMenuProductos)
                .addGap(68, 68, 68)
                .addComponent(lblMenuCarritos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMenuProductos)
                            .addComponent(lblMenuCarritos))
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jPanelCarritos.setBackground(new java.awt.Color(0, 0, 0));
        jPanelCarritos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Carritos Activos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N

        tblCarritos.setBackground(new java.awt.Color(20, 20, 20));
        tblCarritos.setForeground(new java.awt.Color(255, 255, 255));
        tblCarritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Cliente", "Productos", "Unidades", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCarritos.setColumnSelectionAllowed(true);
        tblCarritos.setGridColor(new java.awt.Color(60, 60, 60));
        tblCarritos.setRowHeight(30);
        tblCarritos.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblCarritos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblCarritos);
        tblCarritos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanelCarritosLayout = new javax.swing.GroupLayout(jPanelCarritos);
        jPanelCarritos.setLayout(jPanelCarritosLayout);
        jPanelCarritosLayout.setHorizontalGroup(
            jPanelCarritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarritosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCarritosLayout.setVerticalGroup(
            jPanelCarritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCarritosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );

        jPanelnventario.setBackground(new java.awt.Color(0, 0, 0));
        jPanelnventario.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N

        tblInventario.setBackground(new java.awt.Color(20, 20, 20));
        tblInventario.setForeground(new java.awt.Color(255, 255, 255));
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Stock", "Reservado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventario.setGridColor(new java.awt.Color(60, 60, 60));
        tblInventario.setRowHeight(30);
        tblInventario.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblInventario.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPanel2.setViewportView(tblInventario);
        tblInventario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanelnventarioLayout = new javax.swing.GroupLayout(jPanelnventario);
        jPanelnventario.setLayout(jPanelnventarioLayout);
        jPanelnventarioLayout.setHorizontalGroup(
            jPanelnventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelnventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelnventarioLayout.setVerticalGroup(
            jPanelnventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelnventarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1613, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCarritos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jPanelnventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCarritos, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelnventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        PanelPrincipalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanelCarritos, jPanelnventario});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1613, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        VistaPrincipal vista = new VistaPrincipal(st);
        this.dispose();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarritosActivos;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel TotalEnCarritos;
    private javax.swing.JLabel UnidadesReservadas;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelCarritos;
    private javax.swing.JPanel jPanelnventario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanel2;
    private javax.swing.JLabel lblMenuCarritos;
    private javax.swing.JLabel lblMenuProductos;
    private javax.swing.JTable tblCarritos;
    private javax.swing.JTable tblInventario;
    // End of variables declaration//GEN-END:variables

    // Panel con todo el contenido, para mostrarlo como pestaña dentro del Dashboard
    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    // Header con su logo y título, para que el Dashboard alinee el menu igual que en su propio header
    public JPanel getHeader() {
        return jPanel5;
    }

    public javax.swing.JLabel getLogo() {
        return jLabel11;
    }

    public javax.swing.JLabel getTitulo() {
        return jLabel10;
    }

    // Labels del menu de esta vista, para que el Dashboard los conecte
    public javax.swing.JLabel getMenuProductos() {
        return lblMenuProductos;
    }

    public javax.swing.JLabel getMenuCarritos() {
        return lblMenuCarritos;
    }

    // Detiene la actualizacion automatica (se llama al cerrar el Dashboard)
    public void detener() {
        timerActualizar.stop();
    }

    // Que cada tabla llene su recuadro, con cabecera roja y columnas alineadas
    private void configurarTablas() {
        jPanelCarritos.removeAll();
        jPanelCarritos.setLayout(new BorderLayout());
        jPanelCarritos.add(jScrollPane1, BorderLayout.CENTER);
        jPanelnventario.removeAll();
        jPanelnventario.setLayout(new BorderLayout());
        jPanelnventario.add(jScrollPanel2, BorderLayout.CENTER);

        darEstilo(tblCarritos, jScrollPane1);
        darEstilo(tblInventario, jScrollPanel2);

        // Carritos: N° | Cliente | Productos | Unidades | Total
        int[] anchos = {50, 130, 420, 90, 120};
        for (int i = 0; i < anchos.length; i++) {
            tblCarritos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblCarritos.getColumnModel().getColumn(0).setCellRenderer(alineado(SwingConstants.CENTER));
        tblCarritos.getColumnModel().getColumn(3).setCellRenderer(alineado(SwingConstants.CENTER));
        tblCarritos.getColumnModel().getColumn(4).setCellRenderer(alineado(SwingConstants.RIGHT));

        // Inventario: Producto | Stock | Reservado
        tblInventario.getColumnModel().getColumn(1).setCellRenderer(alineado(SwingConstants.CENTER));
        tblInventario.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean seleccionada, boolean foco, int fila, int columna) {
                super.getTableCellRendererComponent(tabla, valor, seleccionada, foco, fila, columna);
                setHorizontalAlignment(SwingConstants.CENTER);
                // Reservado en rojo y negrita si hay unidades apartadas, gris si es 0
                boolean hayReservas = valor instanceof Integer && (Integer) valor > 0;
                if (!seleccionada) {
                    setForeground(hayReservas ? new Color(255, 80, 80) : new Color(120, 120, 120));
                }
                setFont(hayReservas ? getFont().deriveFont(Font.BOLD) : getFont());
                return this;
            }
        });
    }

    // Cabecera roja, filas oscuras y fondo oscuro en la tabla
    private void darEstilo(JTable tabla, JScrollPane scroll) {
        tabla.getTableHeader().setBackground(new Color(180, 0, 0));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.setShowVerticalLines(false);
        tabla.setFillsViewportHeight(true);
        scroll.getViewport().setBackground(new Color(20, 20, 20));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60)));
    }

    //Celda con el texto alineado 
    private DefaultTableCellRenderer alineado(int alineacion) {
        DefaultTableCellRenderer celda = new DefaultTableCellRenderer();
        celda.setHorizontalAlignment(alineacion);
        return celda;
    }

    // Vuelve a llenar las tablas y las tarjetas con los carritos que aun no se pagan
    private void actualizarDatos() {
        // Borra las filas anteriores para no repetirlas en cada actualizaciom
        modeloCarritos.setRowCount(0);
        // Contadores para las tarjetas de arriba
        int numero = 0;
        int unidadesTotales = 0;
        double montoTotal = 0;

        //Una fila por cada carrito que aun no se paga
        for (Carro c : st.getCarritosActivos()) {
            if (c.getCarritoProductos().isEmpty()) {
                continue; // un carrito vacío no se muestra
            }
            // Arma el texto de productos ("mariajuana, cocacola x2") y suma las unidades del carrito
            StringBuilder productos = new StringBuilder();
            int unidades = 0;
            for (Map.Entry<Producto, Integer> entrada : c.getCarritoProductos().entrySet()) {
                if (productos.length() > 0) {
                    productos.append(", ");
                }
                productos.append(entrada.getKey().getNombre()).append(" x").append(entrada.getValue());
                unidades += entrada.getValue();
            }
            // Agrega la fila: N° | Cliente | Productos | Unidades | Total
            numero++;
            modeloCarritos.addRow(new Object[]{numero, c.getNombre(), productos.toString(), unidades, formatoCLP.format(c.getTotal())});
            // Acumula para las tarjetas
            unidadesTotales += unidades;
            montoTotal += c.getTotal();
        }

        // Inventario: stock que queda en la tienda y cuanto está apartado en carritos
        modeloInventario.setRowCount(0);
        for (Producto p : st.getProductos()) {
            modeloInventario.addRow(new Object[]{p.getNombre(), p.getStock(), st.calcularReservado(p)});
        }

        // Tarjetas de arriba: cantidad de carritos, unidades reservadas y total en dinero
        CarritosActivos.setText(String.valueOf(numero));
        UnidadesReservadas.setText(String.valueOf(unidadesTotales));
        TotalEnCarritos.setText(formatoCLP.format(montoTotal));
    }
}
