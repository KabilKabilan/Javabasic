import java.util.LinkedList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linklist = new LinkedList<>();

        linklist.add(10);
        linklist.add(20);
        linklist.add(30);

        System.out.println(linklist); 
        Collections.reverse(linklist);
        System.out.println(linklist); 

    }
}
