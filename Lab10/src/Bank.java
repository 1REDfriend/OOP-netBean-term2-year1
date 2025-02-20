/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class Bank {
    private Account[] acct;
    private int numAcct;
    
    public Bank() {
        acct = new Account[10];
        numAcct = 0;
    }
    
    public void addAccount(Account ac) {
        if (numAcct == acct.length) return;
        acct[numAcct] = ac;
        numAcct += 1;
    }
    
    public Account getAccount(int index) {
        if (index > numAcct) return null;
        return acct[index];
    }
    
    public int getNumAccount() {
        return numAcct;
    }
}
