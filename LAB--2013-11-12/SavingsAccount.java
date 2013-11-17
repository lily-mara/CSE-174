import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Savings account creater that stores info in text files
 */

public class SavingsAccount {
    
    public static void main(String[] args) throws Exception {
        Scanner kbReader = new Scanner(System.in);
        Scanner fileReader;
        String userName;
        double deposit;
        double balance;
        
        System.out.println();
        System.out.print("Enter Name (No spaces): ");
        userName = kbReader.next();
        
        // reads user balance from file if exists, else balance is set to zero
        File balanceFile = new File(userName + ".txt"); // creates File object
        
        if (balanceFile.exists()) { // checks existence of file
            fileReader = new Scanner(balanceFile); // opens file for reading
            balance = fileReader.nextDouble(); // reads balance
            System.out.printf("Current balance for \"" + userName + "\" is $%.2f \n", balance);
            fileReader.close(); // closes file
        }
        
        else {
            System.out.println("No file exists, starting balance at zero.");
            balance = 0;
        }
        
        // prompts user for deposit amount, adds that to old balance from file
        System.out.print("How much would you like to deposit? ");
        deposit = kbReader.nextDouble();
        balance += deposit;
        System.out.println();
        System.out.printf("User \"%s\" has balance $%.2f", userName, balance);
        
        //writes balance to file
        PrintWriter printer = new PrintWriter(balanceFile);
        printer.println(balance);
        printer.close();
    }
    
}