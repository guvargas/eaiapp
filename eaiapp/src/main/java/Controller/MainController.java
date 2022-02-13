package Controller;

import Data.BancoConversas;
import Data.BancoMensagens;
import Helper.MessageTreatment;
import Model.Conversa;
import Model.Pessoa;
import Thread.SenderThread;
import Thread.HostThread;
import View.ConexaoView;

public class MainController {

    // login
    public MainController() {
        mt = new MessageTreatment();
        banco = new BancoMensagens();
        bancoConversa = new BancoConversas();
    }

    public void definirPorta(int porta) {
        ht = new HostThread(porta, this);
    }

    public void adicionarConversa(String ip, String nome, int porta) {
        bancoConversa.addConversa(new Conversa(ip, nome, porta));
    }

    public void messageReceived(String msg) {
        mt.oraoraUmaMensagemEba(msg, this);

    }

    public void iniciarConexao() {
        SenderThread client = new SenderThread();
        client.start();
    }

    public void criarUsuario(String nome, int porta) {
        usuario = new Pessoa(nome, porta);
    }

    public void ficarOnline() {
        ht.start();
    }

    public void ficarOffline() {
        ht.desligarHost();
    }

    public void abrirTela() {
        ConexaoView cv = new ConexaoView(this);
        cv.setVisible(true);
    }

    // enviar mensagem
    public String enviarMensagem(String mensagem, Conversa contato) {

        BancoMensagens.filaMensagens.add("mensagem;" + nome + ";"
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")) + ";"
                + mensagem);

        String s = "";
        s = mensagem + "\n Enviada às "
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));

        sendToClient(contato);
        return s;

        // enviar mensagem para o servidor
    }

    private void sendToClient(Conversa c) {
        SenderThread client = new SenderThread(c);
        client.start();
    }

    BancoMensagens banco = null;

    BancoConversas bancoConversa = null;
    private Pessoa usuario = null;
    private String nome;
    private HostThread ht = null;
    private MessageTreatment mt = null;
}
