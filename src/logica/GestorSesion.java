package logica;

import entidades.Cliente;

// Gestor de sesion de usuario mantiene el cliente actualmente logueado en toda la aplicación
public class GestorSesion {

    private static Cliente clienteActual = null;

// Inicia sesión con un cliente registrado
    public static void iniciarSesion(Cliente cliente) {
        clienteActual = cliente;
    }

    public static void cerrarSesion() {
        clienteActual = null;
    }

    // Obtiene el cliente actualmente logueado cliente actual o null si no hay sesion
    public static Cliente getClienteActual() {
        return clienteActual;
    }

 // Verifica si hay una sesión activa (cliente registrado)

    public static boolean haySesionActiva() {
        return clienteActual != null;
    }

    public static String getNombreCliente() {
        return clienteActual != null ? clienteActual.getNombre() : "Invitado";
    }

    public static String getRutCliente() {
        return clienteActual != null ? clienteActual.getRut() : null;
    }

    public static String getCorreoCliente() {
        return clienteActual != null ? clienteActual.getCorreo() : null;
    }
}
