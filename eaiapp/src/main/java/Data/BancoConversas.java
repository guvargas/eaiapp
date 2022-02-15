package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import Model.Conversa;
import Model.Mensagem;

public class BancoConversas {
    // private List<Conversa> minhasConversas;
    private ConcurrentHashMap<String, Conversa> conversas;

    public BancoConversas() {
        conversas = new ConcurrentHashMap<String, Conversa>();
    }
    // fazer o get mensagens por aqui pra ver se vai
    public List<Mensagem> getMensagensDeUmaConversa(Conversa conversa) {
    //    System.out.println("AQUI AS MENSAGENS OH: "+conversas.get(conversa.getIp() + ";" + conversa.getPorta()).getMensagens().toString());
        return conversas.get(conversa.getIp() + ";" + conversa.getPorta()).getMensagens();
    }
   
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
