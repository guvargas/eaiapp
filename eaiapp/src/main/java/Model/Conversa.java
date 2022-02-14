package Model;

import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private String IP, nome;
    private int porta;
    private List<Mensagem> mensagens;

    public Conversa(String ip, String nome, int porta) {

        this.IP = ip;
        this.nome = nome;
        this.porta = porta;
        mensagens = new ArrayList<Mensagem>();

    }

    public Mensagem getUltimaMensagem() {
        if(mensagens.size()==0){
            return new Mensagem(" ", " ", "");
        }else{
            return mensagens.get(mensagens.size() - 1);
        }
    }

    public void addMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }

    public String getIp() {
        return this.IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPorta() {
        return this.porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public List<Mensagem> getMensagens() {
        return this.mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

}
