public class Arrays {
    
    public static void main(String[] args) {
        double[] data = {1.0, 7.3, 7/3, Math.PI, 1.5 * Math.PI, Math.E};
//        System.out.println("First element is: " + data[0]);
//        System.out.println("Last element is: " + data[data.length - 1]);
        for (double i : data) {
            System.out.println(i);
        }
        
        System.out.println();
        
        // increase each element by 1
        for (int i = 0; i < data.length; i++)
            data[i] += 1;
        
        for (double i : data) {
            System.out.println(i);
        }
    }
    
}