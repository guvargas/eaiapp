package Controller;

import Data.BancoConversas;
import Data.BancoMensagens;
import Model.Conversa;
import Thread.SenderThread;
import Thread.HostThread;
import View.ConexaoView;
import View.Login;

public class ClienteController {

    BancoMensagens banco = null;
    
    BancoConversas bancoConversa = null;
    private String nome, senha;
    private HostThread ht = null;

    // login
    public ClienteController() {
        banco = new BancoMensagens();
    }

    public void definirPorta(int porta) {
        ht = new HostThread(porta);
    }

    public void adicionarConversa(String ip, String nome, int porta) {
        bancoConversa.addConversa(new Conversa(ip, nome, porta));
    }	
    public void iniciarConexao() {
        SenderThread client = new SenderThread();
        client.start();
    }

    public void ficarOnline() {
        ht.start();
    }

    public void ficarOffline() {
        ht.desligarHost();
    }

    public void realizarLogin(String login, String senha) {

        BancoMensagens.filaMensagens.add("Login;" + login + ";" + senha);
        nome = login;
        this.senha = senha;
    }

    public void abrirTela() {
        // abrir tela
        /*
         * login = new Login(this);
         * login.setVisible(true);
         */
        ConexaoView cv = new ConexaoView(this);
        cv.setVisible(true);

    }

    // enviar mensagem
    public String enviarMensagem(String mensagem) {
        BancoMensagens.filaMensagens.add("Mensagem;" + nome + ";"
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("DD:HH:mm")) + ";"
                + mensagem);

        String s = "";
        s = mensagem + "\n Enviada às "
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
        return s;

        // enviar mensagem para o servidor
    }

}
