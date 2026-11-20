package vistas;

import entidades.Cupon;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import logica.SistemaTienda;

/** Ventana independiente para consultar los cupones guardados en la tienda. */
public class VistaCupones extends JFrame {

    private final SistemaTienda st;
    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"Código", "Descuento", "Usos restantes", "Fecha de creación", "Vencimiento", "Estado"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /** Abre la vista usando el sistema persistido en disco. */
    public VistaCupones() {
        this(SistemaTienda.cargarDatos());
    }

    /** Abre la vista usando la instancia activa de la tienda. */
    public VistaCupones(SistemaTienda st) {
        this.st = st;
        initComponents();
        cargarCupones();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        scrollCupones = new javax.swing.JScrollPane();
        tablaCupones = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cupones disponibles | PoriStore");
        setMinimumSize(new java.awt.Dimension(760, 460));
        setSize(new java.awt.Dimension(900, 560));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setText("Cupones disponibles");

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblDescripcion.setForeground(new Color(185, 185, 185));
        lblDescripcion.setText("Consulta todos los cupones registrados en la tienda.");

        tablaCupones.setModel(modelo);
        tablaCupones.setRowHeight(36);
        tablaCupones.setFont(new java.awt.Font("Segoe UI", 0, 14));
        tablaCupones.setForeground(new Color(35, 35, 35));
        tablaCupones.setSelectionBackground(new Color(255, 220, 225));
        tablaCupones.setSelectionForeground(Color.BLACK);
        tablaCupones.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 13));
        tablaCupones.getTableHeader().setReorderingAllowed(false);
        scrollCupones.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
        scrollCupones.setViewportView(tablaCupones);

        lblEstado.setForeground(new Color(190, 190, 190));
        lblEstado.setText(" ");

        btnActualizar.setBackground(new Color(185, 0, 35));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setText("Actualizar lista");
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        getContentPane().setBackground(new Color(18, 18, 18));
        getContentPane().setLayout(new javax.swing.GroupLayout(getContentPane()));
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) getContentPane().getLayout();
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblDescripcion)
                    .addComponent(scrollCupones, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(7, 7, 7)
            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(scrollCupones, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(lblEstado)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
        );
    }

    /** Recarga el listado desde el sistema de tienda asociado a esta ventana. */
    public void cargarCupones() {
        modelo.setRowCount(0);
        LocalDate hoy = LocalDate.now();
        for (Cupon cupon : st.getCupones()) {
            LocalDate vencimiento = cupon.getCreacion().plusDays(cupon.getDias());
            boolean vigente = cupon.getUsos() > 0 && !vencimiento.isBefore(hoy);
            modelo.addRow(new Object[]{
                cupon.getCodigo(),
                String.format("%.0f%%", cupon.getPorcentaje() * 100),
                cupon.getUsos(),
                cupon.getCreacion(),
                vencimiento,
                vigente ? "Vigente" : "Vencido"
            });
        }
        lblEstado.setText(modelo.getRowCount() == 0
                ? "Todavía no hay cupones registrados."
                : modelo.getRowCount() + (modelo.getRowCount() == 1 ? " cupón registrado" : " cupones registrados"));
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        cargarCupones();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollCupones;
    private javax.swing.JTable tablaCupones;
    // End of variables declaration
}
