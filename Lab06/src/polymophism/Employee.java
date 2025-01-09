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
    private String name;
    private static String nationality="Thai";
    private int energy;
    private Wallet wallet;
    
    public boolean equals(Employee e) {
        return e.name.equals(name);
    }
    
    public String getName() {
        return name;
    }
    
    public Wallet getWallet() {
        return wallet;
    }
    
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public static void setNationality(String nationality) {
        Employee.nationality = nationality;
    }
    
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    
    public int getEnergy() {
        return energy;
    }
    
    public static String getNationality() {
        return nationality;
    }
    
    public void eat(Food f) {
        energy += Food.getEnergy();
    }
    
    public boolean buyFood(Seller s) {
        Food food = s.sell(this);
        if (food != null) {
            this.eat(food);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "My name is  " + this.getName() + ". \nI have " + this.getEnergy() + " energy left.\nI have a balance of " + wallet.getBalance() + " baht.";
    }
}
