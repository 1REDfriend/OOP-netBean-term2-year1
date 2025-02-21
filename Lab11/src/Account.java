/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class Account {
    protected double balance;
    protected String name;
    
    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }
    
    public void deposit(double a) {
        if (a > 0) {
            this.balance += a;
            System.out.println(a+" baht is deposited to "+name+".");
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }
    
    public void withdraw(double a) throws WithdrawException {
        if ((balance - a) > 0) {
            if (a > 0) {
                this.balance -= a;
                System.out.println(a + " baht is withdrawn from " + name + ".");
            } else {
                System.out.println("Input number must be a positive integer.");
            }
        } else {
            throw new WithdrawException("Account "+this.name+" has not enough money!");
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void showAccount() {
        System.out.println(name+" account has "+balance+" baht.");
    }
}
