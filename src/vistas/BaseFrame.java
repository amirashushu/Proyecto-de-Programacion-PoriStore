package vistas;

import logica.SistemaTienda;
import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame{

    protected SistemaTienda st;

    public BaseFrame(SistemaTienda st) {
        this.st = st;
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
}
