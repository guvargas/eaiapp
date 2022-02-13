package Connection;

import java.util.ArrayList;
import java.util.List;

public class Footest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        
        System.out.println(list.toString());
        list.add("b");
        list.add("c");

        System.out.println(list.toString());

        list.remove(0);

        System.out.println(list.toString());
        list.add("a");
        
        System.out.println(list.size());
    }
}
