/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polymophism;

/**
 *
 * @author TEXR
 */
public class Employee {
    private String name, nationality = "Thai";
    private int energy;
    private Wallet wallet;
    
    public boolean equals(Employee e) {
        return e.name.equals(name);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public Wallet getWallet() {
        return wallet;
    }
    
    public void setWallet(Wallet w) {
        wallet = w;
    }
    
    public int getEngergy() {
        return energy;
    }
    
    public void setEnergy(int e) {
        energy = e;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String n) {
        nationality = n;
    }
    
    public void eat(Food f) {
        energy += f.getEngergy();
    }
    
    public boolean buyFood(Seller s) {
        Food food = s.sell(this);
        if (food != null) {
            this.eat(food);
            return true;
        }
        return false;
    }
    
    public String toString() {
        return "My name is  " + name + "\nI have " + energy + " energy left.\nI have a balance of " + wallet.getBalance() + " bath.";
    }
}
