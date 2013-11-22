import java.util.Arrays;

public class MyArrayClass {
	public static void main(String[] args) {
		arrayPrint(tenRun(new int[] {2, 10, 3, 4, 20, 5}));// {2, 10, 10, 10, 20, 20}
		arrayPrint(tenRun(new int[] {10, 1, 20, 2}));// {10, 10, 20, 20}	
		arrayPrint(tenRun(new int[] {10, 1, 9, 20}));// {10, 10, 10, 20}	
		arrayPrint(tenRun(new int[] {1, 2, 50, 1}));// {1, 2, 50, 50}	
		arrayPrint(tenRun(new int[] {1, 20, 50, 1}));// {1, 20, 50, 50}	
		arrayPrint(tenRun(new int[] {10, 10}));// {10, 10}	
		arrayPrint(tenRun(new int[] {10, 2}));// {10, 10}	
		arrayPrint(tenRun(new int[] {0, 2}));// {0, 0}	
		arrayPrint(tenRun(new int[] {1, 2}));// {1, 2}	
		arrayPrint(tenRun(new int[] {1}));// {1}	
		arrayPrint(tenRun(new int[] {}));// {}
	}

	public static int[] tenRun(int[] nums) {
	  int temp;
	  for (int i = 0; i < nums.length; i++) {
	    if (nums[i]%10 == 0) {
	      temp = nums[i];
	      for (int j = i; j < nums.length; j++) {
	        if (nums[j]%10 != 0)
	          nums[j] = temp;
	        else
	          break;
	      }
	    }
	  } 
	  return nums;
	}
	public static void arrayPrint(int[] nums) {
		System.out.println();
		System.out.print("{ ");
		for (int i : nums) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("}");
	}
}

