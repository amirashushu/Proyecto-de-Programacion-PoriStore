package logica;

import entidades.Carro;
import hostCliente.HostCliente;
import javax.swing.*;
import java.awt.*;
import logica.SistemaTienda;
import vistas.DialogoAviso;

public class GestorReserva {
    private static Timer timer;
    private static int segundosRestantes;
    private static int minutosAdmin = 2;
    private static boolean avisoAbierto = false;
    private static DialogoAviso dialogoAviso;
    private static JLabel lblContador;

    // llamar al agregar el primer producto al carro
    public static void iniciar(Carro carro, SistemaTienda st) {
        // si ya está corriendo, no lo reiniciamos
        if (timer != null && timer.isRunning()) {
            return;
        }
        segundosRestantes = minutosAdmin * 60;
        avisoAbierto = false;
        timer = new Timer(1000, e -> {
            segundosRestantes--;
            // 1. cuando queda 1 minuto (60s), abre la alerta encima de la ventana activa
            if (segundosRestantes <= 60 && segundosRestantes > 0) {
                if (!avisoAbierto) {
                    mostrarAlertaGlobal(carro, st);
                    avisoAbierto = true;
                }
                if (dialogoAviso != null) {
                    
                    dialogoAviso.actualizarContador(segundosRestantes);
                }
            }
            // 2. si llega a 0, detiene todo y libera el stock
            if (segundosRestantes <= 0) {
                detener();
                liberarTodo(carro, st);
            }
        });
        timer.start();
    }

    // llamar cuando el cliente termina de pagar o vacía su carrito manualmente
    public static void detener() {
        if (timer != null) {
            timer.stop();
        }
        if (dialogoAviso != null) {
            dialogoAviso.dispose();
            dialogoAviso = null;
        }

        avisoAbierto = false;
    }

    public static void setMinutosAdmin(int minutos) {
        minutosAdmin = minutos;
    }

    private static void mostrarAlertaGlobal(Carro carro, SistemaTienda st) {
        Window ventanaActual = KeyboardFocusManager .getCurrentKeyboardFocusManager() .getActiveWindow(); //detecta la ventana abierta
        dialogoAviso = new DialogoAviso(carro, st);
        dialogoAviso.setLocationRelativeTo(ventanaActual);
        dialogoAviso.setAlwaysOnTop(true);
        dialogoAviso.setVisible(true);
    }

    public static void liberarTodo(Carro carro, SistemaTienda st) {
        st.cancelarCompra(carro);
        Window ventanaActual = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        JOptionPane.showMessageDialog(ventanaActual, "El tiempo expiró. Se vació tu carrito y se liberó el stock.");
    }

    public static Timer getTimer() {
        return timer;
    }

    public static void setTimer(Timer timer) {
        GestorReserva.timer = timer;
    }

    public static int getSegundosRestantes() {
        return segundosRestantes;
    }

    public static void setSegundosRestantes(int segundosRestantes) {
        GestorReserva.segundosRestantes = segundosRestantes;
    }

    public static boolean isAvisoAbierto() {
        return avisoAbierto;
    }

    public static void setAvisoAbierto(boolean avisoAbierto) {
        GestorReserva.avisoAbierto = avisoAbierto;
    }

    public static JLabel getLblContador() {
        return lblContador;
    }

    public static void setLblContador(JLabel lblContador) {
        GestorReserva.lblContador = lblContador;
    }

    public static int getMinutosAdmin() {
        return minutosAdmin;
    } 
}
