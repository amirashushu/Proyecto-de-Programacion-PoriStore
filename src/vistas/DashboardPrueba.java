package vistas;

import logica.SistemaTienda;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DashboardPrueba {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        // EJECUTA EL DASHBOARD
        SwingUtilities.invokeLater(() -> {
            // LOGICA CON TIENDA
            SistemaTienda st = new SistemaTienda();
            
            // MOSTRAR EL DASHBOARD
            Dashboard dashboard = new Dashboard(st);
            dashboard.setVisible(true);
        });
    }
}