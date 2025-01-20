/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class Main {
    public static void main(String[] args) {
        Swordman s1 = new Swordman("John", 100, 200, 1000, "male");
        Swordman s2 = new Swordman("John", 150, 250, 2500, "female");
        
        System.out.println(s1);
        System.out.println(s2);
        
        s1.fighting(s2);
        s1.fighting(s2, 5);
        
        System.out.println(s1);
        System.out.println(s2);
    }
}
