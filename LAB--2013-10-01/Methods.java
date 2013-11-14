public class Methods {
    
    public static void main(String[] args) {
        int [] numbers = {5, 8, 2, 3, 10};
        for(int i : numbers ) {
            System.out.println(f(i));
        }
        int answer = (int) f(8);
    }
    
//  takes a number, returns 6 less than the square of that number
    public static double f(double x) {
        return x * x - 6;
    }
    
//    computes and returns the average of three numbers
//    only works with ints.
    public static int average(int x, int y, int z) {
        return (x + y + z)/3;
    }
}