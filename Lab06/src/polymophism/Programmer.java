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
        if (super.getEnergy() >= 30) {
            System.out.println("Your code is " + str);
            super.setEnergy(super.getEnergy() - 30);
            happiness -= 30;
        } else {
            System.out.println("Error Error Error");
            super.setEnergy(super.getEnergy() - 30);
            happiness -= 30;
        }
    }
    
    public void coding(char str) {
        if (this instanceof SeniorProgrammer) {
            String temp = str+"";
            coding(temp);
            return;
        }
        if (super.getEnergy() >= 30) {
            System.out.println("Your code is " + str);
            super.setEnergy(super.getEnergy() - 30);
            happiness -= 30;
        } else {
            System.out.println("Error Error Error");
            super.setEnergy(super.getEnergy() - 30);
            happiness -= 30;
        }
    }
    
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    
    public int getHappiness() {
        return happiness;
    }
}
