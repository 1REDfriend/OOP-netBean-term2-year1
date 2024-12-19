
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TEXR
 */
public class bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input your money : ");
        double money = sc.nextDouble();
        sc.nextLine();

        System.out.print("Input your account type(Please type A B C or X in uppercase) : ");
        String options = sc.nextLine();

        double newmoney = 0;

        switch (options) {
            case "A", "C" ->
                newmoney = money + (money * 1.5 / 100);
            case "B" ->
                newmoney = money + money * 2.0 / 100;
            case "X" ->
                newmoney = money + money * 2.0 / 100;
            default -> {
            }
        }

        System.out.println("Your total money in one year = " + (int) newmoney);

    }
}
