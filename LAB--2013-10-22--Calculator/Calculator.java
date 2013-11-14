/*
 * CSE 174 lab: Building a text-based calculator
 * This program lets the user enter expressions such
 * as 2.3 + 5 and get back results like 7.3.
 */
import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {    
    Scanner input = new Scanner(System.in);
    double num1, num2;
    String op;
    
    // Read an expression from the user
    System.out.print("Enter an expression: ");
    num1 = input.nextDouble();
    op = input.next();
    num2 = input.nextDouble();
    
    // Now, create a carefully organized approach
    // to displaying results based on the user input.
    
    if (op.equals("+"))
        System.out.println(addition(num1, num2));
    else if (op.equals("-"))
        System.out.println(subtraction(num1, num2));
    else if (op.equals("*"))
        System.out.println(multiply(num1, num2));
    else if (op.equals("/"))
        if (num2 == 0)
            System.out.println("Division: Divide by zero error");
        else
            System.out.println(divide(num1, num2));
    else if (op.equals("^"))
        System.out.println(power(num1, num2));
    else
        System.out.println("Invalid operator");
    
  }
    
  public static String addition(double x, double y) {
      return "Addition: " + x + " + " + y + " = " + (x+y);
  }
  
  public static String subtraction(double x, double y) {
      return "Subtraction: " + x + " - " + y + " = " + (x-y);
  }
  
  public static String multiply(double x, double y) {
      return "Multiplication: " + x + " * " + y + " = " + (x*y);
  }    
  
  public static String divide(double x, double y) {
      return "Division: " + x + " / " + y + " = " + (x/y);
  }
  
  public static String power(double base, double exponent) {
      return "Exponentiation: " + base + " ^ " + exponent + " = " + Math.pow(base,exponent); 
  }
}
    
    
  