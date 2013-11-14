public class MethodLab {

 public static void main(String[] args) {
     
//     testMethod(circleArea(5), 78.54);
//     testMethod(circleArea(8), 201.062);
//     testMethod(circleArea(12), 452.389);
     
//     testMethod(rightTrianglePerimeter(10, 15), 43.028);
//     testMethod(rightTrianglePerimeter(8, 3), 19.544);
     
//     testMethod(remodelingCost(15,20,8), 1460.0);
//     testMethod(remodelingCost(10,30,15), 2100.0);
     
//     testMethod(puppyCount(20.0), 1);
//     testMethod(puppyCount(732.82), 59);
     
//     testMethod(chirpTemperature(50) , 41.06);
//     testMethod(chirpTemperature(123), 56.596);
     
//     testMethod(dieRoll(), 5);
     
}
 
  public static void testMethod(double result, double expected) {
//   I'm so smart.
     System.out.println("Expexted: " + expected);
     System.out.println("Got: " + result);
     System.out.println("");
 }
 
 public static double circleArea(double circleRadius) {
  double pi = Math.PI;
  double radSquared = circleRadius * circleRadius;
  return pi*radSquared;
 }
 
 public static double rightTrianglePerimeter(double leg1, double leg2) {
  double hypot = Math.hypot(leg1, leg2);
  return leg1 + leg2 + hypot;
 }
 
 public static double remodelingCost(double roomWidth, double roomLength, double roomHeight) {
  double floorArea = roomWidth*roomLength;
  double floorCost = floorArea * 2;
  
  double walls1 = 2 * roomLength * roomHeight;
  double walls2 = 2 * roomWidth * roomHeight;
  double wallCost = walls1 + walls2;
  
  double ceilingCost = floorArea;
  
  double totalCost = floorCost + wallCost + ceilingCost;
  
  return totalCost;
 }
  
 public static int puppyCount(double money) {
     return (int)(money / 12.25);
 }
 
 public static double chirpTemperature(int chirpsPerMin) {
     return 50+(chirpsPerMin - 92)/4.7;
 }
 
 public static int dieRoll() {
     double randNum = Math.random();
     randNum *= 6;
     randNum += 1;
     int randInt = (int)randNum;
     
     return randInt;
 }

}