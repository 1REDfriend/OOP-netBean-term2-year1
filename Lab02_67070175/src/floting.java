
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TEXR
 */
public class floting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();

        if (money > 50_000) {
            System.out.println("Tax is " + money * 10.0 / 100);
        } else {
            System.out.println("Tax is " + money * 5.0 / 100);
        }
    }
}
