package Model;

public class Pessoa {
    private String nome;
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


}
