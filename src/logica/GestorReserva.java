package logica;

import entidades.Carro;
import hostCliente.HostCliente;
import javax.swing.*;
import java.awt.*;
import logica.SistemaTienda;

public class GestorReserva {
    private static Timer timer;
    private static int segundosRestantes;
    private static int minutosAdmin = 2;
    private static boolean avisoAbierto = false;
    private static JDialog dialogAviso;
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
                if (lblContador != null) {
                    lblContador.setText("Tu carrito expirará en: " + segundosRestantes + "s");
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
        if (dialogAviso != null) {
            dialogAviso.dispose();
            dialogAviso = null;
        }
        avisoAbierto = false;
    }

    public static void setMinutosAdmin(int minutos) {
        minutosAdmin = minutos;
    }

    private static void mostrarAlertaGlobal(Carro carro, SistemaTienda st) {
        // detecta automáticamente cuál JFrame está usando el cliente ahora mismo
        Window ventanaActual = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();

        dialogAviso = new JDialog(ventanaActual, "Aviso de expiración", Dialog.ModalityType.MODELESS);
        dialogAviso.setSize(330, 140);
        dialogAviso.setAlwaysOnTop(true); // fuerza a que salga encima de cualquier interfaz
        dialogAviso.setLocationRelativeTo(ventanaActual);
        dialogAviso.setLayout(new BorderLayout(10, 10));

        lblContador = new JLabel("Tu carrito expirará en: 60s", SwingConstants.CENTER);
        dialogAviso.add(lblContador, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnContinuar = new JButton("Continuar");
        JButton btnCerrar = new JButton("Cerrar");

        // boton continuar: reinicia el tiempo y cierra el aviso
        btnContinuar.addActionListener(ev -> {
            segundosRestantes = minutosAdmin * 60;
            avisoAbierto = false;
            dialogAviso.dispose();
        });

        // boton cerrar: corta el timer y libera el stock de inmediato
        btnCerrar.addActionListener(ev -> {
            detener();
            liberarTodo(carro, st);
        });

        panelBotones.add(btnContinuar);
        panelBotones.add(btnCerrar);
        dialogAviso.add(panelBotones, BorderLayout.SOUTH);
        dialogAviso.setVisible(true);
    }

    private static void liberarTodo(Carro carro, SistemaTienda st) {
        st.cancelarCompra(carro);
        Window ventanaActual = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        JOptionPane.showMessageDialog(ventanaActual, "El tiempo expiró. Se vació tu carrito y se liberó el stock.");
    }
}
