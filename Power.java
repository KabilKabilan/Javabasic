import java.util.*;

class Main {
    public static int pow(int x, int y) {
        if (y == 0)
            return 1;
        if (y % 2 == 0)
            return pow(x * x, y / 2);
        else
            return x * pow(x * x, (y - 1) / 2);
    }

    public static void main(String args[]) {
        System.out.println(pow(2, 5)); 
        
    }
}
