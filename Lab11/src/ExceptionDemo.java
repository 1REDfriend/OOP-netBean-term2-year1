
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tongt
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please enter 3 numbers as a, b, and c respectively.");
            return;
        }
        
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            double discriminant = b * b - 4 * a * c;

            if (discriminant < 0) {
                System.out.println("INF. it < 0");
                return;
            }

            double sqrtDisc = Math.sqrt(discriminant);

            double x1 = (-b + sqrtDisc) / (2 * a);
            double x2 = (-b - sqrtDisc) / (2 * a);

            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        } catch (NumberFormatException e) {
            System.out.println("Please input data in number format only.");
        }

    }
}
