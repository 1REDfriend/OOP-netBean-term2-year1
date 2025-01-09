/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polymophism;

/**
 *
 * @author TEXR
 */
public class Food{
    private int energy = 10;
    private double price = 50;
    
    public void setPrice(double p) {
        if (p <= price) {
            System.out.println("Cannot update the food price.");
        } else {
            price = p;
        }
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getEngergy() {
        return energy;
    }
}
