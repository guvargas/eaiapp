package Utils;

import java.util.Collection;
import java.util.HashMap;

import javax.swing.DefaultListModel;

import Model.Conversa;

public class JListHelper extends DefaultListModel{

    public JListHelper() {
    }
     
    HashMap<String, Conversa> conversas = new HashMap<>();

    public void addElement(Object o) {
        Conversa c = (Conversa) o;
        conversas.put(c.getNome(), c);
        super.addElement(c.getNome());
    }

    public Conversa getConversa(String nome){
        return conversas.get(nome);
    }


    public boolean removeElement(Object o) {
        Conversa c = (Conversa) o;
        conversas.remove(c.getNome());
        return super.removeElement(c.getNome());
    }
}
