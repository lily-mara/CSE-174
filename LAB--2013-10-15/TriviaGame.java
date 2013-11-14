//  Trivia game for practice /w if statements
import java.util.Scanner;

public class TriviaGame 
{
    static int score;
    static Scanner input;
    
    
    public static void main(String[] args) 
    {
        input = new Scanner(System.in);
        score = 0;
        Question1();
        Question2();
        Question3();
        
    }
    
    public static void Correct()
    {
        System.out.println("You did it!");
        score+=10;
        System.out.println("Your score is now: " + score);
    }
       
    public static void Question1() 
    {
        System.out.println("What is 2 + 2? ");
        int answer = input.nextInt();
        
        if (answer == 4) 
        {
            Correct();
        }
        
        else 
        {
            System.out.println("");
            System.out.println("Are you fucking serious?");
            System.out.println("2 + 2 = " + answer + "????");
            System.out.println("Try again, you moron!");
            System.out.println("");
            Question1();
        }
    }
    
    public static void Question2()
    {
        System.out.println("What colony was the first to get statehood? ");
        String answer = new String(input.next());
        
        if (answer.equals("Delaware") || answer.equals("delaware"))
        {
            Correct();
        }
        
        else
        {
            System.out.println("");
            System.out.println("Oh, I suppose that was a bit complecated...");
            System.out.println("I do have some blocks that you could sit in the corner and play with if you'd like");
            System.out.println("I guess it's reasonable to think that the first state was " + answer + ", if you're a monkey!");
            System.out.println("God, I'm condescending.");
            System.out.println("");
            Question2();
        }
    }
    
    public static void Question3()
    {
        System.out.println("How much is pie? ");
        double answer = input.nextDouble();
        final double errorMargin = 0.001;
        
        if (answer >= Math.PI - errorMargin && answer <= Math.PI + errorMargin)
        {
            Correct();
        }
               
        else
        {
            System.out.println("");
            System.out.println("That was a tricky one.");
            System.out.println("I think that there's a second grader behind you waiting to answer");
            System.out.println("I suppose some people might think that pi is  " + answer + " like, stupid people.");
            System.out.println("Try again...");
            System.out.println("");
            Question3();
        }
    }       
}