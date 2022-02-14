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

    public void definirPorta(int porta) {
        ht = new HostThread(porta, this);
    }

    public List<Mensagem> getMensagens(Conversa conversa) {
        return bancoConversa.getMensagensDeUmaConversa(conversa);
    }

    public void adicionarConversa(String ip, String nome, int porta) {
        bancoConversa.addConversa(new Conversa(ip, nome, porta));
    }
    
    public void abrirConversa(Conversa c) {
        ConversaCliente cc = new ConversaCliente(c, this);
        cc.setVisible(true);
    }

    public void messageReceived(String msg, String ip) {
        mt.oraoraUmaMensagemEba(msg, ip, this);
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

    public List<Conversa> getMinhasConversas() {
        return bancoConversa.getMinhasConversas();
    }
  

    // enviar mensagem
    public void enviarMensagem(String mensagem, Conversa contato) {
        Mensagem m = new Mensagem(mensagem, java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")), usuario.getNome());
        contato.addMensagem(m);
        sendToClient(contato, mt.obaobaQueroMandarPraALguem(mensagem, usuario, contato));
    }

    private void sendToClient(Conversa c, String msg) {
        SenderThread client = new SenderThread(c);
        client.setMensagem(msg);
        client.start();
    }

    public void setTelaPrincipal(PrincipalView principalView) {
        viewPrincipal=  principalView;
    }

    public void refrescar(){
        viewPrincipal.refrescar();
        if(conversaAtual!=null){
            conversaAtual.refrescar();
        }
    }

    public void setConversaAtual(ConversaCliente conversaAtual) {
        this.conversaAtual = conversaAtual;
    }

    private ConversaCliente conversaAtual = null;
    private PrincipalView viewPrincipal =null;
    private BancoConversas bancoConversa = null;
    private Pessoa usuario = null;
    private HostThread ht = null;
    private MessageTreatment mt = null;

    
}
