
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class Hit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please insert your number: ");
        int number = sc.nextInt();
        
        for (int i=1 ; i <= number ; i++ ) {
            if (i % 5 == 0) {
                System.out.print("/");
            }else {
                System.out.print("|");
            }
        }
        
        System.out.println("");
    }
}
