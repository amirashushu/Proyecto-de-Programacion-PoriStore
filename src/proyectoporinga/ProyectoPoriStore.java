package proyectoporinga;

import hostCliente.HostCliente;
import logica.SistemaTienda;
import vistas.VistaPrincipal;

public class ProyectoPoriStore {

    public static void main(String[] args) {
        SistemaTienda sistema = SistemaTienda.cargarDatos();
        Thread hiloCliente = new Thread(() -> {
            HostCliente hc = new HostCliente();
            hc.initHost(sistema.getInventario());
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
