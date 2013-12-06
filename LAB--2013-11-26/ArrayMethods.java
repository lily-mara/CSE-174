/**
 * Several methods for processing arrays.
 * @author Norm Krumpe
 */

import java.util.Arrays;

public class ArrayMethods {

  public static void main(String[] args) {

    int[] a = {7, 2, 15};
    int[] b = new int[20];
    double[] c = {7, 2, 15};
    
    randomFill(b);
    
    println("Swapping 7 and 15 in {7, 2, 15}");
    swap(a, 0, 2);
    printInt(a);
    
    println("\nthe sum of all elements in {7, 2, 15} is ");
    System.out.println(sum(a));
    
    println("\nthe min value in {7, 2, 15} is ");
    System.out.println(min(c));
    
    println("\narray from 20 to 23");
    printInt(fourInARow(20));
    
    println("\n20 coin flips");
    printChar(coinFlips(20));
    
    println("\ndoes {7, 2, 15} contain 20?");
    System.out.println(contains(a, 20));
    
    println("\ndoes 'b' contain 20?");
    printInt(b);
    System.out.println(contains(b, 20));
    
    println("\njust the evens from 'b'?");
    printInt(b);
    printInt(justTheEvens(b));
    
    println("\n{22.5423, 12.53, 18.7, 9.9999999999} rounded down to ints?");
    printInt(roundDown(new double[] {22.5423, 12.53, 18.7, 9.9999999999}));
    
    println("\nall factors of 20?");
    printInt(allFactors(20));

    
//    System.out.println("a: " + Arrays.toString(a));
//    System.out.println("b: " + Arrays.toString(b));
  }

//  pass the array reference to this method,
//  can make any changes to the data in array
//  don't need to return array
  public static void randomFill(int[] nums) {
      for (int i = 0; i < nums.length; i++)
          nums[i] = (int) (Math.random() * 100);
  }
  
  /*
   * Together we will write:
   *   randomFill()
   *   swap()
   *   sum()
   *   contains()
   *
   /**
   * Swaps two elements of an array.
   * @param nums an array of int values
   * @param index1 index of one element to be swapped
   * @param index2 index of another element to be swapped
   */
  public static void swap(int[] nums, int index1, int index2) {
      int temp = nums[index1];
      nums[index1] = nums[index2];
      nums[index2] = temp;
  }

  /**
   * Computes the sum of the elements in the array.
   * @param nums an array of int values to search
   * @return the index of the smallest element from low to high
   */
  public static int sum(int[] nums) {
      int count = 0;
      for (int i : nums)
          count += i;
    return count;

  }


  /**
   * Search for an int in an array of ints.  Returns
   * true if the array contains the element, and false otherwise.
   * @param nums an array to search
   * @param key the value sought
   */
  public static boolean contains(int[] nums, int key) {
      for (int i : nums) {
          if (i == key)
              return true;
      }    
      return false;
  }


  /**
   * Returns the smallest value in an array.
   * @param nums an array of double values to search
   * @return the smallest value in the array
   */
  public static double min(double[] nums) {
      double small = Double.MAX_VALUE;
      for (double i : nums)
          small = Math.min(small, i);
      return small;
  }

  /**
   * Returns an array of 4 consecutive integers, beginning
   * with the value supplied as a parameter.  For example, if
   * the parameter is 7, then the array returned should be
   * {7, 8, 9, 10}.
   * @param start the smallest of the 4 integers to appear in the array
   * @return the first four integers greater than or equal to 4,
   *  in increasing order
   */
  public static int[] fourInARow(int start) {
      int[] nums = new int[4];
      for (int i = 0; i < 4; i++)
          nums[i] = start + i;
      return nums;

  }


  /**
   * Returns an int array consisting of all the factors of num, in
   * increasing order.  For example, if num is 10 then this will
   * return {1, 2, 5, 10}.  If num is less than 1, then the method
   * should return null.
   * @param num a number whose factors are desired
   * @return an array of the factors of num
   */
  public static int[] allFactors(int num) {
      int[] nums = new int[0];
      for (int i = 1; i <= num; i++) {
          if (num % i == 0)
              nums = append(nums, i);
      }
      return nums;

  }

/**
   * Gets an array of coin flips
   * @param n the number of flips desired
   * @return an array of size n containing 't' and 'h'
   * characters representing heads and tails, randomly generated
   */
  public static char[] coinFlips(int n) {
      char[] flips = new char[n];
      for (int i = 0; i < n; i++) {
          if (Math.random() > 0.5)
              flips[i] = 't';
          else
              flips[i] = 'h';
      }
      return flips;
  }

  /**
   * Get an int array containing rounded-down versions
   * of the numbers in a double array.
   * @param d an array of doubles
   * @return the corresponding array of int values, in which
   * element i in the returned array will be the rounded-down version
   * of element i in the original array.
   */
  public static int[] roundDown(double[] d) {
      int[] ints = new int[d.length];
      for (int i = 0; i < d.length; i++)
          ints[i] = (int)d[i];
      return ints;

  }

  /**
   * Gets an int array consisting of all but the first element
   * of a specified array.
   * @param n the original array
   * @return a new array with all except for the first element
   * of the original array.  So, the returned array will have a
   * length that is one shorter than the original.
   */
  public static int[] allButFirst(int[] n) {
      int[] nums = new int[n.length - 1];
      for (int i = 1; i < n.length; i++)
          nums[i - 1] = n[i];
      return nums;
  }

  /**
   * Gets an int array consisting of the original array with one
   * additional value appended to the end.
   * @param n the original array
   * @param value the value to be appended
   * @return a new array that is identical to the original array
   * except that it has the additional value appended to the end
   */
  public static int[] append(int[] n, int value) {
      int[] nums = new int[n.length + 1];
      for (int i = 0; i < n.length; i++)
          nums[i] = n[i];
      nums[nums.length - 1] = value;
      return nums;
  }



  /**
   * Get an array consisting of only the even elements
   * of the original array.
   * @param n an array of int values
   * @return an array consisting of only the even values
   * of n
   */
  public static int[] justTheEvens(int[] n) {
      int[] nums = new int[0];
      for (int i : n) {
          if (i%2 == 0)
              nums = append(nums, i);
          
      }
      append(nums, 200);
      return nums;
  }
  
  public static void printInt(int[] nums) {
      System.out.println(Arrays.toString(nums));
  }
 
  public static void printChar(char[] n) {
      System.out.println(Arrays.toString(n));
  }
  
  public static void printChar(double[] n) {
      System.out.println(Arrays.toString(n));
  }
  
  public static void println(String s) {
      System.out.println(s);
  }


}

