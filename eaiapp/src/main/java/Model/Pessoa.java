package Model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String ip, nome;
    private int porta =8080;

    public Pessoa( String nome,int porta) {
        this.porta= porta;
        this.nome =nome;
     
    }
    public String getNome() {
        return nome;
    }

    public int getPorta() {
        return porta;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

 


}
