/**
* A program that computes the number of boxes needed to ship some teddy bears.
* Fill in the blank with one line of code to get the correct answer.
* Boxes hold 30 teddy bears.
*/
import java.util.Scanner;

public class BoxCalculator {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int bears;
		int boxes;
		System.out.print("How many teddy bears to you need to ship? ");
		bears = keyboard.nextInt();
		if (bears % 30 == 0) {
			boxes = bears / 30;
		}
		else {
			boxes = bears / 30 + 1;
		}

		System.out.println(bears + " bears need " + boxes + " boxes.");
	}
}