/*
Nate Mara
2013-10-03

"ChangeCalculator"

This program Calculates change based on user input

*/

import java.util.Scanner;

public class ChangeCalculator {
	//variables for program
	public static double price;
	public static double givenMoney;
	public static double change;

	public static void main(String[] args) {
		promptUser();
		calculateChange();
	}
		
	public static void promptUser() {
		//asks the user to define the variables
		Scanner keyboard = new Scanner(System.in);

		System.out.print("How much is the item? ");
		price = keyboard.nextDouble();
		System.out.print("\n");

		System.out.print("How much did the customer give you? ");
		givenMoney = keyboard.nextDouble();
		System.out.print("\n");

		System.out.print("Give back $" + (givenMoney - price) + ":");
		System.out.print("\n");
		System.out.print("\n");
	}

	public static void calculateChange() {
		//calculates the change using predefined conditional statements
		change = givenMoney - price;
		conditionalBill(10);
		conditionalBill(5);
		conditionalBill(1);
		change = (change * 100);
		conditionalChange(25);
		conditionalChange(10);
		conditionalChange(5);
		conditionalChange(1);
	}

	public static void conditionalBill(int billSize) {
		// the conditional statement used to calculate change in
		// bills. the denomination can be passed to the method as
		// an int argument.
		if ((int)(change/billSize)>0) {
			System.out.println((int)(change/billSize) + "x $"
				+ billSize + " bills");
		}
		while ((int)(change/billSize)>0) {
			change = change - (int)(billSize);
		}
	}

	public static void conditionalChange(int coinSize) {
		// the conditional statement used to calculate change in
		// coins. the denomination can be passed to the method as
		// an int argument.
		if ((int)(change/coinSize)>0) {
			System.out.println((int)(change/coinSize) + "x "
				+ coinSize + " cent coin");
		}
		while ((int)(change/coinSize)>0) {
			change = change - (int)(coinSize);
		}
	}

}