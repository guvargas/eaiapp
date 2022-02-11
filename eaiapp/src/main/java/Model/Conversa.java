package Model;

import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private String nome, from, to;

    private List<Mensagem> mensagens;

    public Conversa(String nome, String from, String to) {

        this.from = from;
        this.to = to;
        this.nome = nome;
        mensagens = new ArrayList<Mensagem>();

    }

    public void addMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }
}
