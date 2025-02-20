
import java.util.ArrayList;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tongt
 */
public class Customer {
    private String firstName, lastName;
    private ArrayList acct;
    private int numOfAccount;
    
    public Customer() {
        this("", "");
    }
    
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = new ArrayList();
        this.numOfAccount = 0;
    }
   
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Account getAccount(int index) {
        return (Account) this.acct.get(index);
    }
    
    public void addAccount(Account acct) {
        this.acct.add(acct);
        this.numOfAccount ++;
    }
    
    public int getNumOfAccount() {
        return this.acct.size();
    }
    
    @Override
    public String toString() {
        if (!this.acct.isEmpty()) {
           return this.firstName+" "+this.lastName+" doesn’t have account.";
        } 
        
        return "The "+this.firstName+" "+this.lastName+" account has "+this.numOfAccount+" Account.";
    }
    
    public boolean equals(Customer c) {
        return (this.firstName+this.lastName).equals(c.firstName+c.lastName);
    }
    
    
}
