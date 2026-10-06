package proyectoporinga;

import hostCliente.HostCliente;
import logica.SistemaTienda;
import vistas.VistaPrincipal;

public class ProyectoPoriStore {

    public static void main(String[] args) {
        SistemaTienda sistema = SistemaTienda.cargarDatos();
        HostCliente hc = new HostCliente();
        hc.initHost(sistema.getInventario());
        java.awt.EventQueue.invokeLater(() -> {
            VistaPrincipal vista = new VistaPrincipal(sistema);
            vista.setLocationRelativeTo(null); 
            vista.setVisible(true);
            
            
        });
    }
}
