package Controller;

import Data.BancoMensagens;
import Thread.ClientThread;
import View.Login;

public class ClienteController {

    Login login = null;
    BancoMensagens banco = null;
    private String nome,senha;

    // login
    public ClienteController() {
    banco = new BancoMensagens();
    }

    public void iniciarConexao() {
        ClientThread client= new ClientThread();
        client.start();
    }

    public void realizarLogin(String login, String senha) {
    
        BancoMensagens.filaMensagens.add("Login;" + login + ";" + senha);
        nome= login;
       this.senha= senha;
    }

    public void abrirTela() {
        // abrir tela
        login = new Login(this);
        login.setVisible(true);
    }

    // enviar mensagem
    public String enviarMensagem(String mensagem) {
        BancoMensagens.filaMensagens.add("Mensagem;" +nome + ";" + senha+ ";" + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("DD:HH:mm")) + ";" + mensagem);


        String s = "";
        s = mensagem + "\n Enviada às "
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
        return s;

        // enviar mensagem para o servidor
    }

}
