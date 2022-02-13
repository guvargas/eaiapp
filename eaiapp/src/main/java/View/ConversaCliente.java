/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.util.List;

import Controller.MainController;
import Data.BancoConversas;
import Model.Conversa;
import Model.Mensagem;

/**
 *
 * @author guand
 */
public class ConversaCliente extends javax.swing.JFrame {


    MainController controller=null;
    /**
     * Creates new form ConversaCliente
     */
    
    Conversa conversa = null;
    
    public ConversaCliente(){
        initComponents();
    }
    
   public ConversaCliente(Conversa c,MainController clienteController){
        initComponents();
        conversa = c;
        controller=clienteController;
        lbTitulo.setText(c.getNome());
    }
  
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfMensagem = new javax.swing.JTextField();
        taScroll = new javax.swing.JScrollPane();
        taDisplay = new javax.swing.JTextArea();
        btEnviarMensagem = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfMensagem.setToolTipText("Digite sua mensagem aqui");

        taDisplay.setEditable(false);
        taDisplay.setColumns(20);
        taDisplay.setRows(5);
        taScroll.setViewportView(taDisplay);

        btEnviarMensagem.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btEnviarMensagem.setText("Enviar");
        btEnviarMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarMensagemActionPerformed(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbTitulo.setText("Conversa com:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taScroll)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btEnviarMensagem)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(taScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btEnviarMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarMensagemActionPerformed
    String mensagem = "";
    mensagem = tfMensagem.getText();
    controller.enviarMensagem(mensagem,conversa);
    refrescar();
    tfMensagem.setText("");

    }//GEN-LAST:event_btEnviarMensagemActionPerformed

  
    public void atualizarDisplay(String mensagem){
        taDisplay.setText(taDisplay.getText()+"\n"+mensagem);
    }

    public void refrescar(){
        taDisplay.setText("");

        List<Mensagem> mensagens=null;
        for (Conversa c : BancoConversas.minhasConversas) {
            if(c.getNome().equals(conversa.getNome())){
               mensagens = c.getMensagens();
            }
        }
        if(mensagens!= null){
            atualizarMensagens(mensagens);
        }
    }

    private void atualizarMensagens(List<Mensagem> mensagens){
        for (Mensagem m : mensagens) {
            atualizarDisplay(m.getConteudo()+ "\n Enviada às "+m.getHorario());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConversaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConversaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConversaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConversaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConversaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviarMensagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextArea taDisplay;
    private javax.swing.JScrollPane taScroll;
    private javax.swing.JTextField tfMensagem;
    // End of variables declaration//GEN-END:variables
}
