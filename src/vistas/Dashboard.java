package vistas;

import entidades.Categorias;
import entidades.Producto;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.SistemaTienda;


public class Dashboard extends BaseFrame {

    private DefaultTableModel modeloTabla;

    public Dashboard(SistemaTienda st) {
    super(st);
    initComponents();
    this.setLocationRelativeTo(null);
    this.modeloTabla = (DefaultTableModel) tblProductos.getModel();

    txtId.setText("Auto");
    txtId.setEditable(false); // ID autogenerado, no editable por el usuario

    cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(Categorias.values()));
<<<<<<< HEAD
    
=======

    cargarCategoriasEnReportes();

    cbReportCategoria.addActionListener(evt -> actualizarReportes());

>>>>>>> b419411998a154007fa2d3e27e1f9ed81d0053fe
    actualizarTabla(st.getProductos());
    actualizarReportes();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Formulario = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPrecioMin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPrecioMax = new javax.swing.JTextField();
        btnFiltrarPrecio = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbReportCategoria = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1400, 800));

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

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("128");

        jLabel23.setForeground(new java.awt.Color(200, 200, 200));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Total Productos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(30, 30, 30));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jPanel7.setPreferredSize(new java.awt.Dimension(250, 80));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("$ 15.750.000");

        jLabel25.setForeground(new java.awt.Color(200, 200, 200));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Valor Total Inventario");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                .addGap(29, 29, 29))
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
        jLabel27.setForeground(new java.awt.Color(255, 200, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("7");

        jLabel28.setForeground(new java.awt.Color(200, 200, 200));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Stock Crítico");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        Formulario.setBackground(new java.awt.Color(0, 0, 0));
        Formulario.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Gestión de Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N
        Formulario.setToolTipText("");

        txtId.setBackground(new java.awt.Color(30, 30, 30));
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setCaretColor(new java.awt.Color(255, 0, 51));
        txtId.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        txtNombre.setBackground(new java.awt.Color(30, 30, 30));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setCaretColor(new java.awt.Color(255, 0, 51));
        txtNombre.setPreferredSize(new java.awt.Dimension(64, 30));
        txtNombre.addActionListener(this::txtNombreActionPerformed);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción:");

        txtDescripcion.setBackground(new java.awt.Color(30, 30, 30));
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setCaretColor(new java.awt.Color(255, 0, 51));
        txtDescripcion.setPreferredSize(new java.awt.Dimension(64, 30));
        txtDescripcion.addActionListener(this::txtDescripcionActionPerformed);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio:");

        txtPrecio.setBackground(new java.awt.Color(30, 30, 30));
        txtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecio.setCaretColor(new java.awt.Color(255, 0, 51));
        txtPrecio.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Stock:");

        txtStock.setBackground(new java.awt.Color(30, 30, 30));
        txtStock.setForeground(new java.awt.Color(255, 255, 255));
        txtStock.setCaretColor(new java.awt.Color(255, 0, 51));
        txtStock.setPreferredSize(new java.awt.Dimension(64, 30));
        txtStock.addActionListener(this::txtStockActionPerformed);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Categoria:");

        cbCategoria.setBackground(new java.awt.Color(30, 30, 30));
        cbCategoria.setForeground(new java.awt.Color(255, 255, 255));
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Plantas", "Polvos", "Armas", "Accesorios" }));
        cbCategoria.setPreferredSize(new java.awt.Dimension(91, 30));
        cbCategoria.addActionListener(this::cbCategoriaActionPerformed);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID:");

        btnGuardar.setBackground(new java.awt.Color(139, 0, 0));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(75, 35));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnLimpiar.setBackground(new java.awt.Color(40, 40, 40));
        btnLimpiar.setForeground(new java.awt.Color(200, 200, 200));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setPreferredSize(new java.awt.Dimension(72, 35));
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnActualizar.setBackground(new java.awt.Color(40, 40, 40));
        btnActualizar.setForeground(new java.awt.Color(200, 200, 200));
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(82, 35));
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        javax.swing.GroupLayout FormularioLayout = new javax.swing.GroupLayout(Formulario);
        Formulario.setLayout(FormularioLayout);
        FormularioLayout.setHorizontalGroup(
            FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FormularioLayout.createSequentialGroup()
                        .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FormularioLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );
        FormularioLayout.setVerticalGroup(
            FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormularioLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Catálogo de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N

        txtBuscar.setBackground(new java.awt.Color(30, 30, 30));
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setCaretColor(new java.awt.Color(255, 0, 51));
        txtBuscar.setPreferredSize(new java.awt.Dimension(64, 30));
        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        btnBuscar.setBackground(new java.awt.Color(30, 30, 30));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(72, 30));
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnRestablecer.setBackground(new java.awt.Color(30, 30, 30));
        btnRestablecer.setForeground(new java.awt.Color(255, 255, 255));
        btnRestablecer.setText("Restablecer");
        btnRestablecer.setPreferredSize(new java.awt.Dimension(90, 35));
        btnRestablecer.addActionListener(this::btnRestablecerActionPerformed);

        tblProductos.setBackground(new java.awt.Color(20, 20, 20));
        tblProductos.setForeground(new java.awt.Color(255, 255, 255));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Precio", "Stock", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
<<<<<<< HEAD
        tblProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
=======
        tblProductos.setColumnSelectionAllowed(true);
        tblProductos.setGridColor(new java.awt.Color(60, 60, 60));
        tblProductos.setRowHeight(30);
        tblProductos.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblProductos.setSelectionForeground(new java.awt.Color(255, 255, 255));
>>>>>>> b419411998a154007fa2d3e27e1f9ed81d0053fe
        jScrollPane1.setViewportView(tblProductos);
        tblProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnEliminar.setBackground(new java.awt.Color(139, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar Selección");
        btnEliminar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por nombre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(261, 261, 261))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Reportes y Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51)))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Reporte General:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Minimo:");

        txtPrecioMin.setBackground(new java.awt.Color(30, 30, 30));
        txtPrecioMin.setForeground(new java.awt.Color(240, 240, 240));
        txtPrecioMin.setText("Precio min.");
        txtPrecioMin.setCaretColor(new java.awt.Color(220, 20, 60));
        txtPrecioMin.setPreferredSize(new java.awt.Dimension(71, 30));
        txtPrecioMin.addActionListener(this::txtPrecioMinActionPerformed);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Máximo:");

        txtPrecioMax.setBackground(new java.awt.Color(30, 30, 30));
        txtPrecioMax.setForeground(new java.awt.Color(240, 240, 240));
        txtPrecioMax.setText("Precio max.");
        txtPrecioMax.setCaretColor(new java.awt.Color(220, 20, 60));
        txtPrecioMax.setPreferredSize(new java.awt.Dimension(71, 30));
        txtPrecioMax.addActionListener(this::txtPrecioMaxActionPerformed);

        btnFiltrarPrecio.setBackground(new java.awt.Color(139, 0, 0));
        btnFiltrarPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFiltrarPrecio.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrarPrecio.setText("Aplicar Filtro");
        btnFiltrarPrecio.setPreferredSize(new java.awt.Dimension(100, 35));
        btnFiltrarPrecio.addActionListener(this::btnFiltrarPrecioActionPerformed);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("Calculos por Categoria:");

        jLabel16.setBackground(new java.awt.Color(220, 20, 60));
        jLabel16.setForeground(new java.awt.Color(200, 200, 200));
        jLabel16.setText("Seleccionar Categoría:");

        cbReportCategoria.setBackground(new java.awt.Color(30, 30, 30));
        cbReportCategoria.setEditable(true);
        cbReportCategoria.setForeground(new java.awt.Color(240, 240, 240));
        cbReportCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbReportCategoria.setPreferredSize(new java.awt.Dimension(72, 30));

        jLabel17.setBackground(new java.awt.Color(220, 20, 60));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("Precio Promedio: $ 0.0");

        jLabel18.setBackground(new java.awt.Color(220, 20, 60));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Menor Stock: -");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Filtrar por Precio:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("Valor Total Inventario: $0.00");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("Total Productos: 0");

        jSeparator1.setForeground(new java.awt.Color(50, 50, 50));

        jSeparator2.setForeground(new java.awt.Color(50, 50, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(txtPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(txtPrecioMax, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnFiltrarPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel15)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)
                        .addComponent(cbReportCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addComponent(jLabel12)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbReportCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(48, 48, 48)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1616, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(Formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Formulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1616, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txtNombre.getText().trim();
        String desc = txtDescripcion.getText().trim();
        String strPrecio = txtPrecio.getText().trim();
        String strStock = txtStock.getText().trim();
        Categorias cat = (Categorias) cbCategoria.getSelectedItem();

        if (nombre.isEmpty() || desc.isEmpty() || strPrecio.isEmpty() || strStock.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double precio = Double.parseDouble(strPrecio);
            int stock = Integer.parseInt(strStock);

            if (precio < 0 || stock < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "El precio y stock no pueden ser negativos.", "Error de Validación", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtId.getText().equals("Auto")){
                st.crearProducto(nombre, desc, precio, stock, cat); // FIX: precio, no stock
                javax.swing.JOptionPane.showMessageDialog(this, "Producto guardado con éxito.");
                actualizarTabla(st.getProductos());
                
            }else{
                String strId = txtId.getText();
                int id = Integer.parseInt(strId);
                int filaSeleccionada = tblProductos.getSelectedRow();
                st.actualizarProducto(nombre, desc, precio, stock, cat, id);
                modeloTabla.setValueAt(nombre, filaSeleccionada, 1);
                modeloTabla.setValueAt(desc, filaSeleccionada, 2);
                modeloTabla.setValueAt(precio, filaSeleccionada, 3);
                modeloTabla.setValueAt(stock, filaSeleccionada, 4);
                modeloTabla.setValueAt(cat, filaSeleccionada, 5);
                javax.swing.JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.");
                actualizarTabla(st.getProductos());
            }
            
            limpiarCampos();
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Precio y Stock deben ser números válidos.", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        int filaSeleccionada = tblProductos.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla para actualizar.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
        String nombre = modeloTabla.getValueAt(filaSeleccionada, 1).toString();
        String desc = modeloTabla.getValueAt(filaSeleccionada, 2).toString();
        String precio = modeloTabla.getValueAt(filaSeleccionada, 3).toString();
        String stock = modeloTabla.getValueAt(filaSeleccionada, 4).toString();
        Categorias cat = (Categorias) modeloTabla.getValueAt(filaSeleccionada, 5);
        
        txtId.setText(id);
        txtNombre.setText(nombre);
        txtDescripcion.setText(desc);
        txtPrecio.setText(precio);
        txtStock.setText(stock);
        cbCategoria.setSelectedItem(cat);
<<<<<<< HEAD
        
        
=======
>>>>>>> b419411998a154007fa2d3e27e1f9ed81d0053fe
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String criterio = txtBuscar.getText().trim();
        if (criterio.isEmpty()) {
            actualizarTabla(st.getProductos());
        } else {
            actualizarTabla(st.buscarPorNombre(criterio));
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        txtBuscar.setText("");
        actualizarTabla(st.getProductos());
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblProductos.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla para eliminar.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (int) tblProductos.getValueAt(fila, 0);
        String nombre = tblProductos.getValueAt(fila, 1).toString();

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Seguro de eliminar el producto \"" + nombre + "\"?", "Confirmar Eliminación", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            st.eliminarProducto(id);
            actualizarTabla(st.getProductos());
            limpiarCampos();
        }
    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtPrecioMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMinActionPerformed
    }//GEN-LAST:event_txtPrecioMinActionPerformed

    private void txtPrecioMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMaxActionPerformed
    }//GEN-LAST:event_txtPrecioMaxActionPerformed

    private void btnFiltrarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarPrecioActionPerformed
        // Obtener los valores de precio min y max
        String textoMin = txtPrecioMin.getText().trim();
        String textoMax = txtPrecioMax.getText().trim();

        double precioMin = 0;
        double precioMax = 0;

        // Convertir a numeros (si estan vacios quedan en 0)
        try {
            if (!textoMin.isEmpty()) {
                precioMin = Double.parseDouble(textoMin);
            }
            if (!textoMax.isEmpty()) {
                precioMax = Double.parseDouble(textoMax);
            }

            // Filtrar productos por precio
            List<Producto> productosFiltrados = st.filtrarPorPrecio(precioMin, precioMax);
            actualizarTabla(productosFiltrados);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingrese precios válidos",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFiltrarPrecioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Formulario;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrarPrecio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbReportCategoria;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioMax;
    private javax.swing.JTextField txtPrecioMin;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

// Metodos auxiliares

    private void cargarCategoriasEnReportes() {
        Categorias[] todasLasCategorias = Categorias.values();
        int cantidadCategorias = todasLasCategorias.length;
        String[] opcionesReporte = new String[cantidadCategorias + 1];
        opcionesReporte[0] = "Todas";
        for (int i = 0; i < cantidadCategorias; i++) {
            String nombreCategoria = todasLasCategorias[i].toString();
            opcionesReporte[i + 1] = nombreCategoria;
        }
        cbReportCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesReporte));
    }

    private void limpiarCampos() {
        txtId.setText("Auto");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        cbCategoria.setSelectedIndex(0);
        tblProductos.clearSelection();
    }

    private void actualizarReportes() {
        String categoriaSeleccionada = (String) cbReportCategoria.getSelectedItem();

        if (categoriaSeleccionada == null) {
            return;
        }

        // Precio promedio
        double precioPromedio = st.calcularPrecioPromedio(categoriaSeleccionada);
        jLabel17.setText(String.format("Precio Promedio: $%.2f", precioPromedio));

        // Encontrar producto con menor stock
        Producto productoMenorStock = st.obtenerProductoMenorStock(categoriaSeleccionada);

        if (productoMenorStock != null) {
            String nombreProducto = productoMenorStock.getNombre();
            int cantidadStock = productoMenorStock.getStock();
            jLabel18.setText("Menor Stock: " + nombreProducto + " (" + cantidadStock + " unidades)");
        } else {
            jLabel18.setText("Menor Stock: -");
        }

        // Calcular total de inventario
        double valorTotal = st.calcularValorTotalInventario();
        jLabel20.setText(String.format("Valor Total Inventario: $%.2f", valorTotal));

        // Contar total de productos
        int totalProductos = st.getProductos().size();
        jLabel21.setText("Total Productos: " + totalProductos);
    }

    public void actualizarTabla(List<Producto> lista) {
        modeloTabla.setRowCount(0);
        for (Producto p : lista) {
            modeloTabla.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getStock(),
                p.getCategoria()
            });
        }
        actualizarReportes();
    }
}
