import java.util.*;
import java.io.*;
import java.math.*;


public class EulersMethod {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("initial y value at time zero?");
      double prev = scanner.nextDouble(); // inital y 
      System.out.println("number of iterations?");
      int times = scanner.nextInt(); // # of times 
      System.out.println("step value ?");
      double step = scanner.nextDouble(); 
      calculate(prev, times, step);
   }
   
   public static void calculate(double prev, int times, double step) {
      for (int i = 1; i <= times; i++) {
         double value = java.lang.Math.round(step * i * 10000.0) / 10000.0;
         double t = value - step; // t = 0
         double root = java.lang.Math.sqrt(prev);
         double answer = prev + step * ((4 - prev * (t)) / (1 + prev * prev)); // change me 
                                                                  // EULERS METHOD APPROXIMATION FORM: 
                                                                  // y(t + step) = y(t) + y'(t) * step
         System.out.println("time " + (value)  + " = " + answer);
         prev = answer;
      }
   }
}
      