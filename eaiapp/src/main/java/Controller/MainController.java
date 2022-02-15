package Controller;

import java.util.List;

import Data.BancoConversas;
import Helper.MessageTreatment;
import Model.Conversa;
import Model.Mensagem;
import Model.Pessoa;
import Thread.SenderThread;
import Thread.HostThread;
import View.ConexaoView;
import View.ConversaCliente;
import View.PrincipalView;

public class MainController {

    // login
    public MainController() {
        bancoConversa = new BancoConversas();
        mt = new MessageTreatment(bancoConversa);
    }

  

    // parte de banco de dados

    public List<Mensagem> getMensagens(Conversa conversa) {
        return bancoConversa.getMensagensDeUmaConversa(conversa);
    }

    public void adicionarConversa(String ip, String nome, int porta) {
        bancoConversa.addConversa(new Conversa(ip, nome, porta));
    }

    public List<Conversa> getMinhasConversas() {
        return bancoConversa.getMinhasConversas();
    }

    public void removeConversa(Conversa conversa) {
        bancoConversa.removeConversa(conversa);
    }

    // parte de telas

    public void abrirConversa(Conversa c) {
        ConversaCliente cc = new ConversaCliente(c, this);
        cc.setVisible(true);
    }

    public void setConversaAtual(ConversaCliente conversaAtual) {
        this.conversaAtual = conversaAtual;
    }

    public void abrirTela() {
        ConexaoView cv = new ConexaoView(this);
        cv.setVisible(true);
    }

    public void setTelaPrincipal(PrincipalView principalView) {
        viewPrincipal = principalView;
    }

    public void refrescar() {
        viewPrincipal.refrescar();
        if (conversaAtual != null) {
            conversaAtual.refrescar();
        }
    }

    // parte de sockets

    public void messageReceived(String msg, String ip) {
        mt.oraoraUmaMensagemEba(msg, ip, this);
    }

    public void iniciarConexao() {
        SenderThread client = new SenderThread();
        client.start();
    }

    public void ficarOnline() {
        ht.start();
    }

    public void definirPorta(int porta) {
        ht = new HostThread(porta, this);
    }

    // enviar mensagem

    public void enviarMensagem(String mensagem, Conversa contato) {
        Mensagem m = new Mensagem(mensagem,
                java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")),
                usuario.getNome());
        contato.addMensagem(m);
        sendToClient(contato, mt.obaobaQueroMandarPraALguem(mensagem, usuario, contato));
    }

    private void sendToClient(Conversa c, String msg) {
        SenderThread client = new SenderThread(c);
        client.setMensagem(msg);
        client.start();
    }

    private ConversaCliente conversaAtual = null;
    private PrincipalView viewPrincipal = null;
    private BancoConversas bancoConversa = null;
    private Pessoa usuario = null;
    private HostThread ht = null;
    private MessageTreatment mt = null;

    public void criarUsuario(String nome, int porta) {
        usuario = new Pessoa(nome, porta);
    }

}
