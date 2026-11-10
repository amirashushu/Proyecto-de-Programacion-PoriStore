/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import logica.SistemaTienda;

/**
 *
 * @author cristobal
 */
public class Chat extends BaseFrame {
    

    /**
     * Creates new form Chat
     * @param st
     */
    public Chat(SistemaTienda st) {
        super(st);
        initComponents();
        agregarMensaje("PorIA","Hola soy PorIA tu asistente virtual, dime en que te puedo ayudar",false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textChat = new javax.swing.JTextPane() {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return true;
            }
        };
        msgText = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(180, 0, 0));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PorIA: Chat bot");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textChat.setBackground(new java.awt.Color(0, 0, 0));
        textChat.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jScrollPane1.setViewportView(textChat);

        msgText.setBackground(new java.awt.Color(204, 204, 204));
        msgText.addActionListener(this::msgTextActionPerformed);

        btnEnviar.setBackground(new java.awt.Color(180, 0, 0));
        btnEnviar.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(this::btnEnviarActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(msgText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar)
                        .addGap(10, 10, 10))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msgText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        String msg = msgText.getText().trim();
        if (msg.isEmpty()) return;
        agregarMensaje(logica.GestorSesion.getNombreCliente(), msg, true);     
        msgText.setText("");
        btnEnviar.setEnabled(false);
        Thread hilo = new Thread(() -> {try {
                String respuesta = st.llamadoIA(msg);
                javax.swing.SwingUtilities.invokeLater(()->{
                    agregarMensaje("PorIA", respuesta, false);
                });
            } catch (Exception ex) {
                javax.swing.SwingUtilities.invokeLater(()->{
                    agregarMensaje("PorIA","Lo siento, la respuesta tardó demasiado o hubo un problema de conexión", false);
                });
                ex.printStackTrace();
            }finally{
                javax.swing.SwingUtilities.invokeLater(()->{
                    btnEnviar.setEnabled(true);
                    msgText.requestFocus();
                });
            }
            
        });
        hilo.start();
        
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void msgTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgTextActionPerformed
        btnEnviarActionPerformed(evt); 
    }//GEN-LAST:event_msgTextActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField msgText;
    private javax.swing.JTextPane textChat;
    // End of variables declaration//GEN-END:variables
    // Método auxiliar para agregar mensajes con el estilo correcto
    private void agregarMensaje(String remitente, String mensaje, boolean esUsuario) {
        try {
            javax.swing.text.StyledDocument doc = textChat.getStyledDocument();
            javax.swing.text.SimpleAttributeSet estilo = new javax.swing.text.SimpleAttributeSet();

            if (esUsuario) {
                javax.swing.text.StyleConstants.setForeground(estilo, java.awt.Color.WHITE);
                javax.swing.text.StyleConstants.setBold(estilo, true);
            } else {
                javax.swing.text.StyleConstants.setForeground(estilo, new java.awt.Color(255, 107, 107));
                javax.swing.text.StyleConstants.setBold(estilo, true);
            }

            doc.insertString(doc.getLength(), remitente + ": " + mensaje + "\n", estilo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
