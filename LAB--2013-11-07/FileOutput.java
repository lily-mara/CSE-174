//demonstrates basics for writing info to file
import java.io.File;
import java.io.PrintWriter;

public class FileOutput {
    public static void main(String[] args) throws Exception {
        fileOperations();
    }
    
    public static void helloFile() throws Exception {
//        This type of object allows file output
//
//        When writing to a file, data is actually written to RAM
//        instead of slower HDD. When buffer is full, it is dumped to
//        file automatically. Closing file forces buffer to flush.

        PrintWriter printer = new PrintWriter(new File("hello.txt"));
        
        printer.println("Hello World!");
        
        printer.close();
    }
    
    public static void writeNums() throws Exception {
//        Opening a file for writing deletes any old file of the same name
        PrintWriter printer = new PrintWriter(new File("nums.txt"));
        
        for (int i = 1; i <= 10000; i++) {
            printer.println(i);
        }
        
        printer.close();
        }

    public static void fileOperations() throws Exception {
        File f = new File("nums.txt");
        
        System.out.println(f.exists());
        
        if (f.exists()){
            f.delete();
        }
    }
}