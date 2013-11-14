/*
 * WordPlay
 * Nate Mara
 * 2013-11-06
 *
 * Follows a given set of criteria for checking different things
 * about user inputted strings.
 * 
 */

import java.util.Scanner;
import java.lang.Math;

public class WordPlay{

	// keeps prompting the user for a word until 'Q' is entered
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String prompt = "Enter a word for me to analyze (or Q to quit): ";
		System.out.println();
		System.out.print(prompt);

		String userInput;
		userInput = in.next();		

		while (!userInput.equals("Q")) {
			showStats(userInput);
			System.out.print(prompt);
			userInput = in.next();
		}

	}
	
	// after the user enters a word, this shows all the info about it
	public static void showStats(String word) {
		word = word.toUpperCase();
		
		System.out.println();
		System.out.println("Results for " + word + ":");
		System.out.println("Number of vowels: " + vowelCount(word));
		if (vowelCount(word) != 0) {
			char firstVowel = word.charAt(indexOfFirstVowel(word));
			int firstVowelPos = indexOfFirstVowel(word);

			System.out.println("First vowel is: " + firstVowel + " in position " + firstVowelPos);
		}

		System.out.println("Pig Latin: " + pigLatinize(word));
		System.out.println("Ends swapped: " + swapEnds(word));
		System.out.println("Reversed: " + reverse(word));
		System.out.println("Ends swapped and reversed: " + reverse(swapEnds(word)));
		System.out.println("Scrambled: " + multiScramble(word));
		printAllSubstrings(word);
	}

	// returns number of vowels in word using iteration
	public static int vowelCount(String word) {
		int numVowels = 0;

		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			
			if (vowelCheck(currentChar)) {
				numVowels ++;
			}

		}

		return numVowels;

	}

	// returns index of first vowel in word using iteration
	public static int indexOfFirstVowel(String word) {
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			
			if (vowelCheck(currentChar)) {
				return i;
			}
		}
		return -1;


	}

	// returns word translated to 'pig latin'
	public static String pigLatinize(String word) {
		String untilVowel;
		String vowelToEnd;

		if (indexOfFirstVowel(word) == -1)
			return word + "AY";

		else if (indexOfFirstVowel(word) == 0)
			return word + "HAY";

		else
			untilVowel = word.substring(0, indexOfFirstVowel(word));
			vowelToEnd = word.substring(indexOfFirstVowel(word));
			return vowelToEnd + untilVowel + "AY";
	}
	
	// returns the word with the first and last chars switched
	public static String swapEnds(String word) {
		char firstChar = word.charAt(0);
		char lastChar = word.charAt(word.length() - 1);

		if (word.length() == 1)
			return word;

		String middle = word.substring(1, word.length() - 1);

		return lastChar + middle + firstChar;
	}

	// returns the reverse of the word
	public static String reverse(String word) {
		String reversedString = "";

		for (int i = word.length(); i > 0; i--) {
			reversedString += word.charAt(i - 1);
		}

		return reversedString;
	}

	// returns scrambled version of word
	public static String scramble(String word) {
		String scrambleString = "";
		int randInt;
		char randChar;
		int lenWord = word.length();

		for (int i = 0; i < lenWord; i++) {
			randInt = randomNum(0, word.length());
			randChar = word.charAt(randInt);
			scrambleString += randChar;
			word = word.substring(0, randInt) + word.substring(randInt + 1);	
		}

		return scrambleString;
	}

	// returns true if char is vowel, returns false otherwise
	public static boolean vowelCheck(char testChar) {
		boolean isA, isE, isI, isO, isU;
		isA = testChar == 'A';
		isE = testChar == 'E';
		isI = testChar == 'I';
		isO = testChar == 'O';
		isU = testChar == 'U';

		if (isA || isE || isI || isO || isU) {
			return true;
		}
		return false;
	}
	
	// returns random int in range [low, high) (inclusive low, exclusive high)
	public static int randomNum(int low, int high) {
		double randDouble = Math.random();
		int randInt = (int)(randDouble * high);
		return randInt;
	}

	// returns 5 scrambled versions of 'word' each separated by single space
	public static String multiScramble(String word) {
		String stringSum = "";
		for (int i = 0; i < 5; i++) {
			stringSum += scramble(word) + " ";
		}
		return stringSum;
	}

	// prints all substrings of 'word' with asterisk borders on each side
	// and on top/bottom
	public static void printAllSubstrings(String word) {
		int lenWord = word.length();
		int count = 0;

		System.out.println("All substrings of " + word + ":");
		System.out.println(nStars(lenWord));

		for (int length = 1; length <= lenWord; length++) {
			for (int start = 0; start <= lenWord - length; start++) {
				printSubstring(word.substring(start, start + length), lenWord);
				count ++;
			}
		}

		System.out.println(nStars(lenWord));
		System.out.println(count + " substrings found.");
	}

	// returns the top or bottom border for a word 'n' characters long
	public static String nStars(int n) {
		String starString = "";
		n += 4; 
		while (n > 0) {
			starString += "*";
			n--;
		}
		return starString;
	}

	// prints a substring with star and space on either side. totalLength refers
	// to the total length of the original word.
	public static void printSubstring(String substring, int totalLength) {
		int difference = totalLength - substring.length();
		String endingSpace = "";

		for (int i = 0; i < difference; i++){
			endingSpace += " ";
		}
		System.out.println("* " + substring + endingSpace + " *");
	}

}	
