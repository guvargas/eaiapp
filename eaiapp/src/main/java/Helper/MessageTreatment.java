package Helper;

import Controller.MainController;
import Data.BancoConversas;
import Model.Conversa;
import Model.Mensagem;
import Model.Pessoa;

public class MessageTreatment {

    public void oraoraUmaMensagemEba(String msg, String sender, MainController cc) {
        String[] mensagemCortadinha = msg.split(";");
        if (mensagemCortadinha[0].equals("mensagem")) {
            Boolean jaExiste = false;
            Mensagem m = new Mensagem(mensagemCortadinha[4], mensagemCortadinha[3]);
            for (Conversa c : BancoConversas.minhasConversas) {
                if (c.getIp().equals(sender)) {
                    System.out.println("Conversa encontrada");
                    c.addMensagem(m);
                    jaExiste = true;
                }
            }

            if (!jaExiste) {
                String[] s = sender.split(":");
                System.out.println("Conversa nao encontrada");
                Conversa c = new Conversa(s[0].split("/")[1], mensagemCortadinha[2], Integer.parseInt(mensagemCortadinha[1]));

                c.addMensagem(m);
                BancoConversas.minhasConversas.add(c);
            }
        }
        cc.refrescar();
    }

    public String obaobaQueroMandarPraALguem(String msg, Pessoa p, Conversa c) {

        // BancoMensagens.filaMensagens.add("mensagem;" + nome + ";"+
        // java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"))
        // + ";"+ mensagem);

        String s = "mensagem;"+p.getPorta()+";"+ p.getNome() + ";"
                + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")) + ";" + msg;
        return s;
    }

}
