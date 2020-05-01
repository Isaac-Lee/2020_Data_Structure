package midterm;

import java.util.LinkedList;
import java.util.List;

public class List_Test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        System.out.println(list.add(1));
        System.out.println(list);
        System.out.println(list.remove(new Integer(1)));
        System.out.println(list);
    }
}
