public class Searching {
    
    public static void main(String[] args) {
//        int[] testArray = {1, 12, 30, 5, 6, 4, 111}; 
//        System.out.println(linearSearch(testArray, 2));
//        System.out.println(linearSearch(testArray, 12));
//        System.out.println(linearSearch(testArray, 111));
//        System.out.println(linearSearch(testArray, 3));
        
        int[] testBinaryArray = {1, 3, 5, 21, 25, 25, 25, 25, 25, 33, 59, 72, 90};
        
        System.out.println(binarySearch(testBinaryArray, 1));
        System.out.println(binarySearch(testBinaryArray, 4));
        System.out.println(binarySearch(testBinaryArray, 33));
        System.out.println(binarySearch(testBinaryArray, 21));
        System.out.println(binarySearch(testBinaryArray, 25));
    }
    
//    returns FIRST index of key in nums 
    public static int linearSearch(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key)
                return i;
        }
        return -1;
    }
    
//    returns AN index of key in nums
    public static int binarySearch(int[] nums, int key) {
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        int midIndex = (lowIndex + highIndex) / 2;
        
        while (nums[midIndex] != key) {
            if (key < nums[midIndex])
                highIndex = midIndex - 1;
            else
                lowIndex = midIndex + 1;
            
            midIndex = (lowIndex + highIndex) / 2;
            
            if (highIndex < lowIndex)
                return -1;
        }
        
        return midIndex;
    }   
}
