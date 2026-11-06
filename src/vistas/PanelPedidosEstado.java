package vistas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.SistemaTienda;

// Vista del admi: lista de pedidos con su estado, y el detalle del pedido seleccionado para avanzarlo o cancelarlo
public final class PanelPedidosEstado extends BaseFrame {

    private final DefaultTableModel modeloPedidos;
    //Refresca los datos cada 2 segundos para ver los pedidos nuevos casi al instante
    private final Timer timerActualizar;

    public PanelPedidosEstado(SistemaTienda st) {
        super(st);
        initComponents();
        this.modeloPedidos = (DefaultTableModel) tblPedidos.getModel();
        configurarTabla();
        actualizarDatos();
        timerActualizar = new Timer(2000, e -> actualizarDatos());
        timerActualizar.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelPendientes = new javax.swing.JPanel();
        labelPendientes = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panelPreparacion = new javax.swing.JPanel();
        labelPreparacion = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panelDespachados = new javax.swing.JPanel();
        labelDespachados = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblMenuCarritos = new javax.swing.JLabel();
        lblMenuProductos = new javax.swing.JLabel();
        lblMenuVentas = new javax.swing.JLabel();
        lblMenuPedidos = new javax.swing.JLabel();
        jPanelEstado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        labelInfoCliente = new javax.swing.JLabel();
        labelTitutloCambiar = new javax.swing.JLabel();
        labelProductos = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelEstadoActual = new javax.swing.JLabel();
        comboxEstado = new javax.swing.JComboBox<>();
        labelFecha = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnActualizar = new javax.swing.JButton();
        jPanelPedidos = new javax.swing.JPanel();
        comboxFiltrar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

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

        panelPendientes.setBackground(new java.awt.Color(30, 30, 30));
        panelPendientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        panelPendientes.setPreferredSize(new java.awt.Dimension(250, 80));

        labelPendientes.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        labelPendientes.setForeground(new java.awt.Color(255, 255, 255));
        labelPendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPendientes.setText("0");

        jLabel23.setForeground(new java.awt.Color(200, 200, 200));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Pendientes");

        javax.swing.GroupLayout panelPendientesLayout = new javax.swing.GroupLayout(panelPendientes);
        panelPendientes.setLayout(panelPendientesLayout);
        panelPendientesLayout.setHorizontalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPendientesLayout.setVerticalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelPreparacion.setBackground(new java.awt.Color(30, 30, 30));
        panelPreparacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        panelPreparacion.setPreferredSize(new java.awt.Dimension(250, 80));

        labelPreparacion.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        labelPreparacion.setForeground(new java.awt.Color(255, 0, 51));
        labelPreparacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPreparacion.setText("0");

        jLabel25.setForeground(new java.awt.Color(200, 200, 200));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("En Preparación");

        javax.swing.GroupLayout panelPreparacionLayout = new javax.swing.GroupLayout(panelPreparacion);
        panelPreparacion.setLayout(panelPreparacionLayout);
        panelPreparacionLayout.setHorizontalGroup(
            panelPreparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreparacionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelPreparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPreparacion, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPreparacionLayout.setVerticalGroup(
            panelPreparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreparacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPreparacion)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelDespachados.setBackground(new java.awt.Color(30, 30, 30));
        panelDespachados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        panelDespachados.setPreferredSize(new java.awt.Dimension(250, 80));

        labelDespachados.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        labelDespachados.setForeground(new java.awt.Color(255, 200, 0));
        labelDespachados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDespachados.setText("0");

        jLabel28.setForeground(new java.awt.Color(200, 200, 200));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Despachados");

        javax.swing.GroupLayout panelDespachadosLayout = new javax.swing.GroupLayout(panelDespachados);
        panelDespachados.setLayout(panelDespachadosLayout);
        panelDespachadosLayout.setHorizontalGroup(
            panelDespachadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDespachadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDespachadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDespachados, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDespachadosLayout.setVerticalGroup(
            panelDespachadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDespachadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDespachados)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblMenuCarritos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuCarritos.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuCarritos.setText("Carritos Activos");

        lblMenuProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuProductos.setText("Productos");

        lblMenuVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuVentas.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuVentas.setText("Ventas");

        lblMenuPedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuPedidos.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuPedidos.setText("Pedidos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMenuProductos)
                .addGap(18, 18, 18)
                .addComponent(lblMenuCarritos)
                .addGap(27, 27, 27)
                .addComponent(lblMenuVentas)
                .addGap(29, 29, 29)
                .addComponent(lblMenuPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panelPreparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(panelDespachados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelDespachados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelPreparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMenuProductos)
                            .addComponent(lblMenuCarritos)
                            .addComponent(lblMenuVentas)
                            .addComponent(lblMenuPedidos))
                        .addGap(36, 36, 36))))
        );

        jPanelEstado.setBackground(new java.awt.Color(0, 0, 0));
        jPanelEstado.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Detalle del pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pedido N°");

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar pedido");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        labelInfoCliente.setBackground(new java.awt.Color(0, 0, 0));
        labelInfoCliente.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelInfoCliente.setForeground(new java.awt.Color(170, 170, 170));
        labelInfoCliente.setText("Cliente:");

        labelTitutloCambiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTitutloCambiar.setForeground(new java.awt.Color(255, 255, 255));
        labelTitutloCambiar.setText("Nuevo estado:");

        labelProductos.setBackground(new java.awt.Color(0, 0, 0));
        labelProductos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelProductos.setForeground(new java.awt.Color(170, 170, 170));
        labelProductos.setText("Productos:");

        labelTotal.setBackground(new java.awt.Color(0, 0, 0));
        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(255, 255, 255));
        labelTotal.setText("Total:");

        labelEstadoActual.setBackground(new java.awt.Color(0, 0, 0));
        labelEstadoActual.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelEstadoActual.setForeground(new java.awt.Color(170, 170, 170));
        labelEstadoActual.setText("Estado actual:");

        comboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "En preparación", "Despachado", "Entregado" }));

        labelFecha.setBackground(new java.awt.Color(0, 0, 0));
        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(170, 170, 170));
        labelFecha.setText("Fecha:");

        btnActualizar.setBackground(new java.awt.Color(180, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar estado");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        javax.swing.GroupLayout jPanelEstadoLayout = new javax.swing.GroupLayout(jPanelEstado);
        jPanelEstado.setLayout(jPanelEstadoLayout);
        jPanelEstadoLayout.setHorizontalGroup(
            jPanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelTotal)
                        .addComponent(labelProductos)
                        .addComponent(labelTitutloCambiar)
                        .addComponent(labelInfoCliente)
                        .addComponent(jLabel1)
                        .addComponent(jSeparator2)
                        .addComponent(comboxEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelFecha)
                        .addComponent(labelEstadoActual)
                        .addComponent(jSeparator3)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelEstadoLayout.setVerticalGroup(
            jPanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEstadoActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelProductos)
                .addGap(61, 61, 61)
                .addComponent(labelTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitutloCambiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPedidos.setBackground(new java.awt.Color(0, 0, 0));
        jPanelPedidos.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)), "Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 0, 51))))); // NOI18N

        comboxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendiente", "En preparación", "Despachado", "Entregado", "Cancelado" }));
        comboxFiltrar.addActionListener(this::comboxFiltrarActionPerformed);

        tblPedidos.setBackground(new java.awt.Color(20, 20, 20));
        tblPedidos.setForeground(new java.awt.Color(255, 255, 255));
        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Cliente", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidos.setColumnSelectionAllowed(true);
        tblPedidos.setGridColor(new java.awt.Color(60, 60, 60));
        tblPedidos.setRowHeight(30);
        tblPedidos.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblPedidos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblPedidos);
        tblPedidos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filtrar por:");

        javax.swing.GroupLayout jPanelPedidosLayout = new javax.swing.GroupLayout(jPanelPedidos);
        jPanelPedidos.setLayout(jPanelPedidosLayout);
        jPanelPedidosLayout.setHorizontalGroup(
            jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(jPanelPedidosLayout.createSequentialGroup()
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelPedidosLayout.setVerticalGroup(
            jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboxFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxFiltrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboxEstado;
    private javax.swing.JComboBox<String> comboxFiltrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelEstado;
    private javax.swing.JPanel jPanelPedidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelDespachados;
    private javax.swing.JLabel labelEstadoActual;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelInfoCliente;
    private javax.swing.JLabel labelPendientes;
    private javax.swing.JLabel labelPreparacion;
    private javax.swing.JLabel labelProductos;
    private javax.swing.JLabel labelTitutloCambiar;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel lblMenuCarritos;
    private javax.swing.JLabel lblMenuPedidos;
    private javax.swing.JLabel lblMenuProductos;
    private javax.swing.JLabel lblMenuVentas;
    private javax.swing.JPanel panelDespachados;
    private javax.swing.JPanel panelPendientes;
    private javax.swing.JPanel panelPreparacion;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables


    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public JPanel getHeader() {
        return jPanel5;
    }

    public javax.swing.JLabel getLogo() {
        return jLabel11;
    }

    public javax.swing.JLabel getTitulo() {
        return jLabel10;
    }

    // Opciones del menú de esta vista (el Dashboard les pone el clic para cambiar de vista)
    public javax.swing.JLabel getMenuProductos() {
        return lblMenuProductos;
    }

    public javax.swing.JLabel getMenuCarritos() {
        return lblMenuCarritos;
    }

    public javax.swing.JLabel getMenuVentas() {
        return lblMenuVentas;
    }

    public javax.swing.JLabel getMenuPedidos() {
        return lblMenuPedidos;
    }

    // Detiene el timer (el Dashboard debe llamarlo al cerrarse)
    public void detener() {
        timerActualizar.stop();
    }

    // Estilo de la tabla: cabecera roja, filas oscuras, anchos y columnas centradas (el tamaño lo da el Design)
    private void configurarTabla() {
        tblPedidos.getTableHeader().setBackground(new Color(180, 0, 0));
        tblPedidos.getTableHeader().setForeground(Color.WHITE);
        tblPedidos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblPedidos.getTableHeader().setReorderingAllowed(false);
        tblPedidos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblPedidos.setShowVerticalLines(false);
        tblPedidos.setFillsViewportHeight(true);
        jScrollPane1.getViewport().setBackground(new Color(20, 20, 20));
        jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60)));

        // Columnas: N° | Cliente | Fecha | Estado
        int[] anchos = {50, 200, 130, 130};
        for (int i = 0; i < anchos.length; i++) {
            tblPedidos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblPedidos.getColumnModel().getColumn(0).setCellRenderer(alineado(SwingConstants.CENTER)); // N°
        tblPedidos.getColumnModel().getColumn(2).setCellRenderer(alineado(SwingConstants.CENTER)); // Fecha
        tblPedidos.getColumnModel().getColumn(3).setCellRenderer(alineado(SwingConstants.CENTER)); // Estado
    }

    // Crea un formato de celda con el texto alineado
    private DefaultTableCellRenderer alineado(int alineacion) {
        DefaultTableCellRenderer celda = new DefaultTableCellRenderer();
        celda.setHorizontalAlignment(alineacion);
        return celda;
    }

    // Recarga la tabla cada 2 segundos.
    private void actualizarDatos() {
        modeloPedidos.setRowCount(0);
        // Pendiente: llenar la tabla y las tarjetas con los pedidos
    }
}
