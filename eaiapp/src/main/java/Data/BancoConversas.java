package Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Model.Conversa;

public class BancoConversas {
    // private List<Conversa> minhasConversas;
    private HashMap<String, Conversa> conversas;

    public BancoConversas() {
        conversas = new HashMap<String, Conversa>();
    }
//fazer o get mensagens por aqui pra ver se vai
    public void addConversa(Conversa conversa) {
        conversas.put(conversa.getIp() + ";" + conversa.getPorta(), conversa);
        // minhasConversas.add(conversa);
    }

    public void removeConversa(Conversa conversa) {
        conversas.remove(conversa.getIp() + ";" + conversa.getPorta());
    }

    public List<Conversa> getMinhasConversas() {
        return new ArrayList<Conversa>(conversas.values());
    }

    public Conversa getConversa(String ip, int porta) {
        return conversas.get(ip + ";" + porta);
    }

}
