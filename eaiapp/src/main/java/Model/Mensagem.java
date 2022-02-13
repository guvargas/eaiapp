package Model;

public class Mensagem {
    private String conteudo,horario;

    public Mensagem(String conteudo, String horario) {
        this.conteudo = conteudo;
        this.horario = horario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
}
