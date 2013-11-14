/*
 * Nate Mara
 * 2013-10-10
 */

public class MoreMethods {
    
    public static void main(String[] args) {
        System.out.println(isEven(20));
    }
    
    public static String repeat3(String inputString) {
        /*
         * Returns a given String repeated 3 times
         */
        boolean spaces = true;
        
        if (spaces) {
            return inputString + " " + inputString + " " + inputString;
        }
        else {
            return inputString + inputString + inputString;
        }
    }
    
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    public static boolean isPositive(int num) {
        return num > 0;
    }
    
    public static boolean sameFirst(String a, String b) {
        return a.charAt(0) == b.charAt(0);
    }
    
    public static String coinFlip() {
        return (Math.random() < 0.5) ? "Heads" : "Tails";
    }
    
}