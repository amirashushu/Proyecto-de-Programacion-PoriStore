package proyectoporinga;

import logica.SistemaTienda;
import vistas.VistaPrincipal;

public class ProyectoPoriStore {

    public static void main(String[] args) {
        SistemaTienda sistema = SistemaTienda.cargarDatos();
        java.awt.EventQueue.invokeLater(() -> {
            VistaPrincipal vista = new VistaPrincipal(sistema);
            vista.setLocationRelativeTo(null); 
            vista.setVisible(true);
        });
    }
}
