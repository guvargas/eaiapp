package Data;

import java.util.HashMap;

import Model.Pessoa;

public class Banco {

    private static HashMap<String, Pessoa> pessoas;
    // a key eh o ip mais o login

    public Banco() {
        pessoas = new HashMap<String, Pessoa>();
    }

    // get conversas

    // get mensagens

    public void addPessoa(Pessoa p) {
        pessoas.put(p.getIp() + ";" + p.getLogin(), p);
    }

    public boolean login(String ip, String login, String senha) {
        if (pessoas.containsKey(ip + ";" + login)) {
            Pessoa p = pessoas.get(login);
            if (p.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public String cadastrar(String ip, String login, String senha) {
        if (pessoas.containsKey(ip + ";" + login)) {
            return "Login existente";
        } else {
            Pessoa p = new Pessoa(ip, login, senha);
            addPessoa(p);
            return "Cadastro realizado com sucesso";
        }
    }

}
