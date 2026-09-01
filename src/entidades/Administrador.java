
package entidades;

import java.io.Serializable;

public class Administrador implements Serializable{
    private String nombre;
    private String contraseña;
    private String correo;

    public Administrador(String nombre, String contraseña, String correo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    public boolean validarContraseña(String contraseña){
        return contraseña.equals(this.contraseña);
    }
}
