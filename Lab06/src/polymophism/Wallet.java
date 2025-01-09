/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polymophism;

/**
 *
 * @author TEXR
 */
public class Wallet extends Employee{
    private double balance;
    
    /**
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
}
