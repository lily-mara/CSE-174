//Gets 3 words from user and prints them
import java.util.Scanner;

public class UserInput {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word1;
        String word2;
        String word3;
        System.out.println("Please enter three words: ");
        
        word1 = in.next();
        word2 = in.next();
        word3 = in.next();
        
        System.out.println(word1 + ", " + word2 + ", " + word3);
    }
    
}