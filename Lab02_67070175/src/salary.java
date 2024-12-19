
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TEXR
 */
public class salary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = 0, bonus = 0;

        System.out.print("Please insert your name : ");
        String name = sc.nextLine();

        System.out.print("Please insert your age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Please insert number of working days : ");
        int numDay1 = sc.nextInt();
        sc.nextLine();

        System.out.print("Please insert number of absent days : ");
        int numDay2 = sc.nextInt();
        sc.nextLine();

        System.out.print("Please insert your body weight : ");
        double weight = sc.nextDouble();

        System.out.println("Hi, " + name);

        if (age >= 21 & age <= 30) {
            salary = (numDay1 * 300) - (numDay2 * 50);
        } else if (age >= 31 & age <= 40) {
            salary = (numDay1 * 500) - (numDay2 * 50);
        } else if (age >= 41 & age <= 50) {
            salary = (numDay1 * 1000) - (numDay2 * 25);
        } else if (age >= 51 & age <= 60) {
            salary = (numDay1 * 300);
        }

        if (weight >= 10 & weight <= 60) {
            bonus = 5000;
        } else if (weight >= 61 & weight <= 90) {
            bonus = (5000 - ((weight - 60) * 10));
        }

        System.out.println("Your salary is " + (int) (salary) + " Baht");
        System.out.println("Your salary and bonus is " + (int) (salary + bonus) + " Baht");
    }
}
