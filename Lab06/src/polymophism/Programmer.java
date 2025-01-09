/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polymophism;

/**
 *
 * @author TEXR
 */
public class Programmer extends Employee{
    private int happiness;
    
    public void coding(String str) {
        if (super.getEngergy() >= 30) {
            System.out.println("Your code is " + str);
            super.setEnergy(super.getEngergy() - 30);
            happiness -= 30;
        } else {
            System.out.println("Error Error Error");
            super.setEnergy(super.getEngergy() - 30);
            happiness -= 30;
        }
    }
    
    public void coding (char str) {
        if (super.getEngergy() >= 30) {
            System.out.println("Your code is " + str);
            super.setEnergy(super.getEngergy() - 30);
            happiness -= 30;
        } else {
            System.out.println("Error Error Error");
            super.setEnergy(super.getEngergy() - 30);
            happiness -= 30;
        }
    }
    
    public int getHappiness() {
        return happiness;
    }
    
    public void setHappiness(int h) {
        happiness = h;
    }
}
