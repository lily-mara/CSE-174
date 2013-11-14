public class LoopStuff {
    
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            System.out.println(stars(i));
        }
    }
    
    public static String stars(int starCount) {
        String output = "";
        
        for (int i = 0; i < starCount; i++) {
            output += "*";
        }
        
        return output;
    }
    
}
