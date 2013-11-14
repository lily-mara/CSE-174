// Nate Mara
// Lab: Loop-controlled grade entry
// October 31, 2013
// Description: This lab gives practice
//   with using a loop to control data entry.
//   Inside the loop will be code to process
//   the data, item by item.

import java.util.Scanner;

public class GradeEntry {
   public static void main(String[] args) {

      // DECLARE VARIABLES HERE
      Scanner in = new Scanner(System.in);
      double currentTestScore;
      String allScores = "";
      int numScores = 0;
      double currentMax;
      double currentMin;
      double runningTotal = 0;
      double meanScore = 0;
      int displayScore = 2;



      // BEFORE the loop ask the user for the first number.
      System.out.print("Enter test score #1 (negative quits): ");
      currentTestScore = in.nextDouble();
      currentMax = currentTestScore;
      currentMin = currentTestScore;
      
      // Use a while loop to process scores as long
      // as the user enters scores that aren't negative.
      // INSIDE the loop is where all the data processing
      // will go.
      while (currentTestScore >= 0) {
          allScores += currentTestScore + " ";
          runningTotal += currentTestScore;
                    
          currentMax = Math.max(currentMax, currentTestScore);
          currentMin = Math.min(currentMin, currentTestScore);
                    
          System.out.print("Enter test score #" + displayScore +
                           " (negative quits): ");
          currentTestScore = in.nextDouble();
          
          numScores++;
          displayScore ++;
          meanScore = runningTotal / numScores;
      }

      // AFTER the loop, display the results.  This
      // is where you should check to see whether to
      // display "No data entered." or to display
      // the average, min, max, etc.
      if (allScores.length() == 0) {
          System.out.println();
          System.out.println("No data entered.");
      }
      
      else {
          System.out.println();
          System.out.println("You entered " + numScores + " test scores:");
          System.out.println(allScores);
          System.out.println();
          System.out.println("The mean score is " + meanScore);
          System.out.println("The lowest score is " + currentMin);
          System.out.println("The highest score is " + currentMax);
      }

   }
}


