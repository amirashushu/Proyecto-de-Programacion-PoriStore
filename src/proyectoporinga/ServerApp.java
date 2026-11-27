package proyectoporinga;

import logica.SistemaTienda;
import vistas.VistaLogin;

/** Inicia la aplicación de administración y el servidor de PoriStore. */
public final class ServerApp {
    private ServerApp() { }

    public static void main(String[] args) {
        System.setProperty("poristore.server.mode", "true");
        HostApp.configurarInterfaz();
        SistemaTienda sistema = SistemaTienda.cargarDatos();

        java.awt.EventQueue.invokeLater(() -> {
            VistaLogin vista = new VistaLogin(sistema);
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        });
    }
}
