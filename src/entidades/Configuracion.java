package entidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.err.println("Aviso: No se encontró config.properties");
        }
    }

    public static String get(String clave) {
        String valor = props.getProperty(clave);
        return (valor != null) ? valor : System.getenv(clave);
    }
}
