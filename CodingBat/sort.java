import java.util.Arrays;
public class inst {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedInsert(8, new int[] {5, 7, 11, 20})));
	}

	public static int[] sortedInsert(int n, int[] nums) {
  		int[] temp = new int[nums.length + 1];
		int tempNum;
		  
		for (int i = 0; i < nums.length; i++)
		    temp[i] = nums[i];
		
		temp[nums.length] = n;
		  
		for (int j = temp.length - 1; j >= 0; j--) {
		    for (int i = 0; i < j; i++) {
		        if (temp[i] > temp[i+1]) {
		            tempNum = temp[i];
		            temp[i] = temp[i+1];
		            temp[i+1] = tempNum;
		        }
		    }
		}
		  
		return temp;
		    
	}

	public static void printArray(int[] nums) {
		System.out.println(Arrays.toString(nums));
	}

}
