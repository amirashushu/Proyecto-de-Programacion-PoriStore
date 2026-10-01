package vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// Panel que dibuja una imagen de fondo sin deformarla, con una capa oscura para que el texto encima se lea
public class PanelImagen extends JPanel {

    private Image imagen;

    // Recibe la ruta dentro del proyecto
    public PanelImagen(String ruta) {
        URL url = getClass().getResource(ruta);
        if (url != null) {
            imagen = new ImageIcon(url).getImage();
        }
        setBackground(new Color(20, 20, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            // Escala la imagen para cubrir todo el panel sin deformarla
            double escala = Math.max((double) getWidth() / imagen.getWidth(this), (double) getHeight() / imagen.getHeight(this));
            int ancho = (int) (imagen.getWidth(this) * escala);
            int alto = (int) (imagen.getHeight(this) * escala);
            g.drawImage(imagen, (getWidth() - ancho) / 2, (getHeight() - alto) / 2, ancho, alto, this);
        }
        //Capa negra semitransparente 
        g.setColor(new Color(0, 0, 0, 110));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
