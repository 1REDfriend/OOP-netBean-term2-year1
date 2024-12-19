
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class EvenOrOdd {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int even = 0, odd = 0;
        
        while (true) {
            int number = sc.nextInt();
            
            if (number == -1) {
                break;
            }else {
                if (number % 2 == 0) {
                    even++;
                }else {
                    odd++;
                }
            }
        }
        
        System.out.println("Odd number = " + odd + " and Even number = " + even);
    }
}
