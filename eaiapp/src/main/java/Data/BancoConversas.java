package Data;

import java.util.ArrayList;
import java.util.List;

import Model.Conversa;

public class BancoConversas {
    public static List<Conversa> minhasConversas;

    public BancoConversas(){
        minhasConversas= new ArrayList<Conversa>();
    }

    public void addConversa(Conversa conversa){
        minhasConversas.add(conversa);
    }

    public void removeConversa(Conversa conversa){
        minhasConversas.remove(conversa);
    }
    

}
