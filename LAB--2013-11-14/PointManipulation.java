// want to create and manipulate point objects
// 1. create point at (10, 20)
// 2. shift right by 15
// 3. print average of x and y coordinates

import java.awt.Point;

public class PointManipulation {
    public static void main(String[] args) {
        Point p;
        p = new Point(10, 20);
        
        System.out.println(p.getX());
        
        // translate is a "setter method" it changes the object
        // also known as "mutator method"
        p.translate(15, 0);
        
        // getX() is a "getter" method. Doesn't change obj, just
        // accesses its data
        System.out.println(p.getLocation());
        
        // average of point
        System.out.println(average(p));
        
    }
    
    public static double average(double x, double y) {
        return (x + y) / 2;
    }
    
    public static double average(Point inPoint) {
        return (inPoint.getX() + inPoint.getY()) / 2;
    }
    
}