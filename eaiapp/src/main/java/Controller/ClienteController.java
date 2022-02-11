package Controller;

import View.ConversaCliente;

public class ClienteController {

    ConversaCliente c = null;

    // login
    public ClienteController() {
        
    }

    public void iniciarConexao(){
        
    }

    public void abrirTela() {
        // abrir tela
        c = new ConversaCliente(this);
        c.setVisible(true);
    }

    // enviar mensagem
    public String enviarMensagem(String mensagem) {

    String s= "";
    s= mensagem+"\n Enviada às "+java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
    return s;
      
        // enviar mensagem para o servidor
    }

}
