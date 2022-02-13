package Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Footest {
    public static void main(String[] args) {
         HashMap<Integer,String> minhasConversas = new HashMap<Integer,String>();

         minhasConversas.put(1,"Conversa 1");
            minhasConversas.put(2,"Conversa 2");
            minhasConversas.put(3,"Conversa 3");
            System.out.println(minhasConversas.get(1));
            
            System.out.println(minhasConversas.get(5));

    }
}
