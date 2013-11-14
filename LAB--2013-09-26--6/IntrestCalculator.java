/////////////////////////////////////////////////////////////////////
//a simple intrest calculator based on:
//  Intrest = P * (1 + r)^y
//    P = Principle
//    r = intrest rate
//    y = number of years
//
//in this version, all numbers are hard-coded
/////////////////////////////////////////////////////////////////////
public class IntrestCalculator {
    
    public static void main(String[] args) {
        double principle, rate;
        int years;
        double intrest;
        
        principle = 500.00;
        rate = 0.01;
        years = 70;
        
        intrest = principle * Math.pow((1 + rate), years);
        
        System.out.println("The intrest after " + years + 
                           " years is $" + intrest);
    }
    
}