package Model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String ip, login, senha;
    private List<Conversa> conversas;


    public Pessoa(String ip, String login, String senha) {
        this.ip = ip;
        this.login = login;
        this.senha = senha;
        conversas = new ArrayList<Conversa>();
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Conversa> getConversas() {
        return this.conversas;
    }

    public void setConversas(List<Conversa> conversas) {
        this.conversas = conversas;
    }


}
