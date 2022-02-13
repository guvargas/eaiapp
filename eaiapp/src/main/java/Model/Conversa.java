package Model;

import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private String nome, from, to;
    private int porta;
    private Mensagem ultimaMensagem;

    private List<Mensagem> mensagens;

    public Conversa(String nome, String from, String to, int porta) {

        this.from = from;
        this.to = to;
        this.nome = nome;
        this.porta = porta;
        this.ultimaMensagem = new Mensagem("", "");
        mensagens = new ArrayList<Mensagem>();

    }

    public void addMensagem(Mensagem mensagem) {
        ultimaMensagem = mensagem;
        mensagens.add(mensagem);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Mensagem getUltimaMensagem() {
        return ultimaMensagem;
    }

    public void setUltimaMensagem(Mensagem ultimaMensagem) {
        this.ultimaMensagem = ultimaMensagem;
    }
    
}
