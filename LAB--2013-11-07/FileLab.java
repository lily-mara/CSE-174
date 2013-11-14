import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class FileLab {

    public static void main(String [] args) throws Exception {
        System.out.println("There are " + countK() + " 'k's in the first 10,000 words.");
        
        final int lineNum = 12345;
        System.out.println("The word on line " + lineNum + " is " + atLine(lineNum) + ".");
        
        System.out.println(wordsWithLength(2));
        System.out.println(wordsWithLength(3));
        System.out.println(wordsWithLength(4));
        System.out.println(wordsThatEndWith('Q'));
        System.out.println(aNotB('Q', 'U'));
        System.out.println(onlyAtIndex('B', 3));
    }
    
    public static int countK() throws Exception {
        Scanner words = new Scanner(new File("words.txt"));
        int kCount = 0;
        String currentWord;
        
        for (int i = 0; i < 10000; i++) {
            currentWord = words.next();
            if (currentWord.indexOf('K') != -1) {
                kCount++;
            }
            
        }    
        
        words.close();
        return kCount;
    }
    
    public static String atLine(int lineNumber) throws Exception {
        Scanner words = new Scanner(new File("words.txt"));
        String currentWord = "";
        
        for (int i = 0; i < lineNumber; i++) {
            currentWord = words.next();
        }
        
        return currentWord;
    }
    
    public static String wordsWithLength(int wordLength) throws Exception{
        Scanner words = new Scanner(new File("words.txt"));
        String currentWord;
        int wordCount = 0;
        
        while (words.hasNext()) {
            currentWord = words.next();
            
            if (currentWord.length() == wordLength) {
                wordCount++;
            }
            
        }
        
        words.close();
        return "There are " + wordCount + " words with " + wordLength + " letters.";
    }
    
    public static String wordsThatEndWith(char testChar) throws Exception {
        Scanner words = new Scanner(new File("words.txt"));
        String currentWord;
        int wordCount = 0;
        char lastChar = 'a';
        
        while (words.hasNext()) {
            currentWord = words.next();
            lastChar = currentWord.charAt(currentWord.length() - 1);
            
            
            if (lastChar == testChar) {
                wordCount++;
            }
            
        }
        
        words.close();
        return "There are " + wordCount + " words ending with char '" + testChar + "'.";
    }
    
    public static String aNotB(char a, char b) throws Exception {
        Scanner words = new Scanner(new File("words.txt"));
        int count = 0;
        String currentWord = "";
        
        while (words.hasNext()) {
            currentWord = words.next();
            boolean hasA = currentWord.indexOf(a) != -1;
            boolean hasB = currentWord.indexOf(b) != -1;
            
            if (hasA && !hasB) {
                count++;
            }
            
        }    
        
        words.close();
        return "There are " + count + " words that contain char '" + a + "' but not char '" + b + "'.";
    }
    
    public static String onlyAtIndex(char testChar, int testIndex) throws Exception {
        Scanner words = new Scanner(new File("words.txt"));
        int count = 0;
        String currentWord = "";
        boolean hasAtTestIndex = false;
        boolean hasAtZero = true;
        boolean hasAtOne = true;
        
        while (words.hasNext()) {
            currentWord = words.next();
            if (currentWord.length() - 1 > testIndex) {
            hasAtTestIndex = currentWord.charAt(testIndex) == testChar;
            hasAtZero = currentWord.charAt(0) == testChar;
            
            if(currentWord.length() > 1) {
                hasAtOne = currentWord.charAt(1) == testChar;
            }
            
            if (hasAtTestIndex && !hasAtZero && !hasAtOne) {
                count++;
            }
            }
        }    
        
        words.close();
        return "There are " + count + " words that have char '" + testChar + "' at index " + testIndex + ", but not 0 or 2.";
    }
}