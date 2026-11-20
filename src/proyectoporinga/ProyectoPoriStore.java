package proyectoporinga;

import hostCliente.HostCliente;
import javax.swing.UIManager;
import logica.SistemaTienda;
import vistas.VistaPrincipal;

public class ProyectoPoriStore {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SistemaTienda sistema = SistemaTienda.cargarDatos();
        Thread hiloCliente = new Thread(() -> {
            HostCliente hc = new HostCliente();
            hc.initHost(sistema);
        });
        hiloCliente.setDaemon(true);
        hiloCliente.start();

        java.awt.EventQueue.invokeLater(() -> {
            VistaPrincipal vista = new VistaPrincipal(sistema);
            HostCliente.setVistaPrincipal(vista);
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        });
    }
}