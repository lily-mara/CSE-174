public class StringStuff {
    
    public static void main(String[] args) {
         
        System.out.println(reverse("cat"));
 
    }
    
    public static String reverse(String inputWord) {
        String reverseWord = "";
        
        int counter = 0;
        
        for (int i = inputWord.length() - 1; i >= 0; i--) {
            reverseWord += inputWord.charAt(i);
            if (inputWord.charAt(i) == 'a')
                counter++;
        }
        
        return reverseWord;
    }
}