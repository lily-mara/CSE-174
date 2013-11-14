/*
Nate Mara
2013-10-03

"Wing Load Calculator"

This program calculates the lbs/sq-ft 
load of a parachuter while falling

*/

import java.util.Scanner;

public class WingLoadCalculator {
	//variables for user prompts/equation
	public static double jumperWeight;
	public static double rigWeight;
	public static double parachuteSize;
	public static double wingLoad;
	
	public static void main(String[] args) {
		//calls all of the methods nesicarry for the program to run
		welcomeBanner();
		promptUser();
		calculateLoad();
		printWingLoad();
	}

	public static void welcomeBanner() {
		//prints this banner for the user
		println("");
		println("--------------------------------------------------");
		println("--------------------------------------------------");
		println("||    Welcome to Nate's Wing Load Calculator    ||");
		println("||         Version 0.0.0.1 (alpha build)        ||");
		println("||                                              ||");
		println("||  This program can be used to calculate the   ||");
		println("||  pounds-per-square-foot load of a parachute. ||");
		println("||                                              ||");
		println("|| NOTICE: This software should not be used for ||");
		println("|| lifesaving advice, please consult a licensed ||");
		println("||  skydiving instructor before attempting any  ||");
		println("||    dangerous activities such as skydiving.   ||");
		println("||                                              ||");
		println("||   To get started, look at the prompt below.  ||");
		println("--------------------------------------------------");
		println("--------------------------------------------------");
		println("");	
		println("");	
	}

	public static void promptUser() {
		//prompts the user for information about the jumper
		Scanner keyboard = new Scanner(System.in);

		print("Please enter the weight of the jumper in pounds: ");
		jumperWeight = keyboard.nextDouble();
		print("\n");

		print("Please enter the weight of the rig (parachute & container) in pounds: ");
		rigWeight = keyboard.nextDouble();
		print("\n");

		print("Please enter the size of the parachute in square feet: ");
		parachuteSize = keyboard.nextDouble();
		print("\n");
	}

	public static void calculateLoad() {
		//defines the wingload variable
		wingLoad = (jumperWeight + rigWeight) / parachuteSize;
	}

	public static void printWingLoad() {
		//prints the sentence containing all of the info for the user
		println("For a diver weighing " + jumperWeight + 
			" lbs, and a rig weighing " + rigWeight + 
			" lbs," + "\n" + "the wing-load is " + wingLoad + 
			" lbs/sq-ft.");
		println("");
	}

	public static void println(String arg1) {
		//simplifies the println function
		System.out.println(arg1);
	}

	public static void print(String arg1) {
		//simplifies the print function
		System.out.print(arg1);
	}

}