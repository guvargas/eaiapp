package Helper;

import Controller.MainController;
import Model.Pessoa;

public class MessageTreatment {

    public void oraoraUmaMensagemEba(String msg, MainController cc) {
        String[] mensagemCortadinha = msg.split(";");
        if (mensagemCortadinha[0].equals("mensagem")) {



        }
    }

    public String obaobaQueroMandarPraALguem(String msg, Pessoa p){
        return msg;
    }

}
