/////////////////////////////////////////////////////////////////////
//a simple intrest calculator based on:
//  Intrest = P * (1 + r)^y
//    P = Principle
//    r = intrest rate
//    y = number of years
//
//in this version, all numbers come from the user
/////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class UserIntrestCalculator {
    
    public static void main(String[] args) {
        double principle, rate;
        int years;
        double intrest;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("");
        System.out.print("What is the principle? $");
        principle = keyboard.nextDouble();
        
        System.out.println("");
        System.out.print("What is the intrest rate? ");
        rate = keyboard.nextDouble() / 100;
        
        System.out.println("");
        System.out.print("How many years? ");
        years = keyboard.nextInt();
        
        intrest = principle * Math.pow((1 + rate), years);
        
        System.out.println("The intrest after " + years + 
                           " years is $" + intrest);
    }
    
}