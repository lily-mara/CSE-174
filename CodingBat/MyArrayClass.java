import java.util.Arrays;

public class MyArrayClass {
	public static void main(String[] args) {
		testPre4();
	}

	public static int[] tenRun(int[] nums) {
		int temp;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]%10 == 0) {
				temp = nums[i];
				for (int j = i + 1; j < nums.length; j++) {
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

	public boolean isEverywhere(int[] nums, int val) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != val && nums[i + 1] != val)
				return false;
		}
		return true;
	}	

	public boolean has22(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 2 && nums[i + 1] == 2)
				return true;
		}
		return false;
	}

	public static int[] pre4(int[] nums) {
		int[] temp = new int[0];
		int i = 0;
		while (nums[i] != 4) {
			temp = {temp, i};
			i++;
		}
		return temp;
	  
	}

	public static void testPre4() {
		arrayPrint(pre4(new int[] {1, 2, 4, 1}));// {1, 2}
		arrayPrint(pre4(new int[] {3, 1, 4}));// {3, 1}
		arrayPrint(pre4(new int[] {1, 4, 4}));// {1}
		arrayPrint(pre4(new int[] {1, 4, 4, 2}));// {1}      
		arrayPrint(pre4(new int[] {1, 3, 4, 2, 4}));// {1, 3}	
		arrayPrint(pre4(new int[] {4, 4}));// {}	
		arrayPrint(pre4(new int[] {3, 3, 4}));// {3, 3}	
		arrayPrint(pre4(new int[] {1, 2, 1, 4}));// {1, 2, 1}
		arrayPrint(pre4(new int[] {2, 1, 4, 2}));// {2, 1}
		arrayPrint(pre4(new int[] {2, 1, 2, 1, 4, 2}));// {2, 1, 2, 1}
	}
	
	public static void tenRun() {
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
}

