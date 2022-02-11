package Connection;

import java.util.ArrayList;
import java.util.List;

public class Footest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list.get(0));

        list.remove(0);

        System.out.println(list.get(0));
    }
}
