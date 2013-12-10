import java.util.Arrays;
public class inst {
	public static void main(String[] args) {
		printArray(insert(new int[] {4, 7, 2, 8, 5}, 3, 0));
		printArray(insert(new int[] {5, 10, 15, 20, 25, 30, 35, 40}, 5, 2));
		printArray(insert(new int[] {5, 10, 15, 20, 25, 30, 35, 40}, 5, 5));
		printArray(insert(new int[] {0, 1, 2, 3, 4, 5}, 5, 0));
		printArray(insert(new int[] {0, 1, 2, 3, 4, 5}, 5, 4));
		printArray(insert(new int[] {0, 1, 2, 3, 4, 5}, 5, 5));
	}

	
	public static int[] insert(int[] nums, int startingLocation, int finalLocation) {
		int start = nums[startingLocation];
		int end = nums[finalLocation];


		for (int i = finalLocation; i < nums.length; i++) {
			int temp = nums[i];
			nums[i] = nums[finalLocation];
			nums[finalLocation] = temp;
		}	

		//nums[finalLocation] = start;


		
		//int temp = 0;
		//for (int i = finalLocation + 1; i < nums.length - 1; i++) {
			//temp = nums[i];
			//nums[i] = nums[i - 1];
		//}

		//nums[finalLocation] = start;
		//nums[startingLocation] = end;
  
		return nums;
	}

	public static void printArray(int[] nums) {
		System.out.println(Arrays.toString(nums));
	}

}
