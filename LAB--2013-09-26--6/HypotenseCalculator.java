/**
 * A program that computes the hypotenuse
 * length of a right triangle
 */

import java.util.Scanner;

public class HypotenseCalculator {
    public static void main(String[] args) {
        
        double base1, base2;
        double hypotenuse;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter the lengths of the bases:");
        base1 = keyboard.nextDouble();
        base2 = keyboard.nextDouble();
        
        hypotenuse = Math.hypot(base1, base2);
        
        System.out.println("In a triangle with bases " + base1 +
                           " and " + base2 + 
                           ",\nthe hypotenuse is " + hypotenuse + ".");
    }
}