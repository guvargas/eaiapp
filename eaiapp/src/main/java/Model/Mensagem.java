package Model;

public class Mensagem {
    private String conteudo,horario,sender;

    public Mensagem(String conteudo, String horario, String sender) {
        this.conteudo = conteudo;
        this.horario = horario;
        this.sender = sender;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getSender(){
        return sender;
    }

    public void setSender(String send){
        this.sender = send;
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
