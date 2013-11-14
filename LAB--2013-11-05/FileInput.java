//Gets 3 words from a file and prints them
import java.util.Scanner;
import java.io.File;

public class FileInput {
    
    public static void main(String[] args) throws Exception {
        readThreeWords();
        readSomeFourLetteredWords();
    }
    
    public static void readThreeWords() throws Exception {
        Scanner in = new Scanner(new File("words.txt"));
        String word1;
        String word2;
        String word3;
        System.out.println("Now reading three words from file: ");
        
        word1 = in.next();
        word2 = in.next();
        word3 = in.next();
        
        System.out.println(word1 + ", " + word2 + ", " + word3);
        in.close();
    }
    
//    reads first 10,000 words, prints those with 4 letters
    public static void readSomeFourLetteredWords() throws Exception {
        Scanner in = new Scanner(new File("words.txt"));
        String word;
        
        System.out.println("Now reading four-lettered words from file: ");
        int count = 0;
        
        for (int i = 0; i < 10000; i++) {
            word = in.next();
            if (word.length() == 4) {
                System.out.println(word);
                count ++;
            }
        }
        System.out.println("That was " + count + " four-lettered words.");
        
        in.close();
    }
//    reads in all words, prints 4 lettered words
    public static void readAllFourLetteredWords() throws Exception {
        Scanner in = new Scanner(new File("words.txt"));
        String word;
        
        System.out.println("Now reading four-lettered words from file: ");
        int count = 0;
        
        while (in.hasNext()) {
            word = in.next();
            if (word.length() == 4) {
                System.out.println(word);
                count ++;
            }
        }
        System.out.println("That was " + count + " four-lettered words.");
        
        in.close();
    }
    
}