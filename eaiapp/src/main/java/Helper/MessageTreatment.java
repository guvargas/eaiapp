package Helper;

import Controller.MainController;
import Data.BancoConversas;
import Model.Conversa;
import Model.Mensagem;
import Model.Pessoa;

public class MessageTreatment {

    // tipo, porta, nome, hora, mensagem
    // 0 1 2 3 4
    private BancoConversas bc;

    public MessageTreatment(BancoConversas bc) {
        this.bc = bc;

    }

    public void oraoraUmaMensagemEba(String msg, String ipDeQuemEnviou, MainController cc) {
        String[] mensagemCortadinha = msg.split(";");
        if (mensagemCortadinha[0].equals("mensagem")) {
            Boolean jaExiste = false;
            Mensagem m = new Mensagem(mensagemCortadinha[4], mensagemCortadinha[3], mensagemCortadinha[2]);
            for (Conversa c : bc.getMinhasConversas()) {
                if (c.getIp().equals(ipDeQuemEnviou)) {
                    // System.out.println("Conversa encontrada");
                    m.setSender(c.getNome());
                    c.addMensagem(m);
                    jaExiste = true;
                }
            }

            if (!jaExiste) {
                String[] s = ipDeQuemEnviou.split(":");
                System.out.println("Conversa nao encontrada");
                Conversa c = new Conversa(s[0].split("/")[1], mensagemCortadinha[2],
                Integer.parseInt(mensagemCortadinha[1]));
                c.addMensagem(m);
                bc.addConversa(c);
            }
        }
        cc.refrescar();
    }

    public String obaobaQueroMandarPraALguem(String msg, Pessoa p, Conversa c) {

        // BancoMensagens.filaMensagens.add("mensagem;" + nome + ";"+
        // java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"))
        // + ";"+ mensagem);

        String s = "mensagem;" + p.getPorta() + ";" + p.getNome() + ";"
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")) + ";" + msg;
        return s;
    }

}
