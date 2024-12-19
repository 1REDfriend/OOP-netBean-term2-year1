package student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class Student {
    public String name;
    public double mScore, fScore;
    
    public void showGrade() {
        double s = (mScore*0.4)+(fScore*0.4)+ 20;
        System.out.print("Your grade is ");
        if (s >= 80) {
            System.out.println("A");
        }else if (s >= 70) {
            System.out.println("B");
        }else if (s >= 60) {
            System.out.println("C");
        }else if (s >= 50) {
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }
}