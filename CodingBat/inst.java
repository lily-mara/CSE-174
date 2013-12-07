import java.util.Arrays;
public class inst {
	public static void main(String[] args) {
		printArray(insert(new int[] {5, 7, 11, 20}, 3, 0));
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
