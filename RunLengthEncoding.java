public class Stringin {
    public static void main(String[] args) {
        String s = "abbcddeee";
        char[] c = s.toCharArray(); 

        String o = "";
        int b = 1;

        for (int i = 0; i < c.length; i++) {
            
            if (i < c.length - 1 && c[i] == c[i + 1]) {
                b++;
            } else {
                
                o += c[i];
                
                if (b > 1) {
                    o+= b;
                }
                b = 1; 
            }
        }

        System.out.println(o);
    }
}
