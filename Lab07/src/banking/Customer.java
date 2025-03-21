package banking;

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
    private CheckingAccount acct;
    
    public Customer() {
        this("", "", null);
    }
    
    public Customer(String firstName, String lastName) {
        this(firstName, lastName, null);
    }
    
    public Customer(String firstName, String lastName, CheckingAccount acct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = acct;
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
    
    public void setAcct(CheckingAccount acct) {
        this.acct = acct;
    }
    
    public CheckingAccount getAcct() {
        return acct;
    }
    
    @Override
    public String toString() {
        if (this.getAcct() == null) {
           return firstName+" "+lastName+" doesn’t have account.";
        } 
        
        return "The "+firstName+" account has "+acct.getBalance()+" baht and "+acct.getCredit()+" credits.";
    }
    
    public boolean equals(Customer c) {
        return (this.firstName+this.lastName).equals(c.firstName+c.lastName);
    }
    
    
}
