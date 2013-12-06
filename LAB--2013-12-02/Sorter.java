import java.util.Arrays;

public class Sorter {
    
    public static void main(String[] args) {
//        int[] test = {12, 3, 10, 15, 20, 1, 3, -20, 200, 15, 7, 8, 4};
//        sort(test);
//        System.out.println(Arrays.toString(test));
    }
    
    public static void sort(int[] nums) {
        for (int j = nums.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (Math.max(nums[i], nums[i+1]) == nums[i])
                    swap(nums, i, i+1);
            }
        }
    }
    
    public static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}