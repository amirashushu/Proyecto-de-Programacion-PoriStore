package proyectoporinga;

import hostCliente.HostCliente;
import javax.swing.UIManager;
import logica.SistemaTienda;
import vistas.VistaPrincipal;

/** Inicia la aplicación de tienda en modo cliente (host). */
public final class HostApp {
    private HostApp() { }

    public static void main(String[] args) {
        System.setProperty("poristore.data", "datosPoriStore-host.dat");
        configurarInterfaz();
        SistemaTienda sistema = SistemaTienda.cargarDatos();

        Thread hiloCliente = new Thread(() -> new HostCliente().initHost(sistema), "poristore-host");
        hiloCliente.setDaemon(true);
        hiloCliente.start();

        java.awt.EventQueue.invokeLater(() -> {
            VistaPrincipal vista = new VistaPrincipal(sistema);
            HostCliente.setVistaPrincipal(vista);
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        });
    }

    static void configurarInterfaz() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
