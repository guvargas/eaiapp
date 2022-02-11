package Controller;

import Data.BancoClient;
import Thread.ClientThread;
import View.ConversaCliente;
import View.Login;

public class ClienteController {

    Login login = null;
    BancoClient banco = null;
    private String nome,senha;

    // login
    public ClienteController() {
    banco = new BancoClient();
    }

    public void iniciarConexao() {
        ClientThread client= new ClientThread();
        client.start();
    }

    public void realizarLogin(String login, String senha) {
    
        BancoClient.filaMensagens.add("Login;" + login + ";" + senha);
        nome= login;
        senha= senha;
    }

    public void abrirTela() {
        // abrir tela
        login = new Login(this);
        login.setVisible(true);
    }

    // enviar mensagem
    public String enviarMensagem(String mensagem) {
        BancoClient.filaMensagens.add("Mensagem;" +nome + ";" + senha+ ";" + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("DD:HH:mm")) + ";" + mensagem);


        String s = "";
        s = mensagem + "\n Enviada às "
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
        return s;

        // enviar mensagem para o servidor
    }

}
