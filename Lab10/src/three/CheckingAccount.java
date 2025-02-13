

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tongt
 */
public class CheckingAccount extends Account {

    private double credit;

    public CheckingAccount() {
        super(0, "");
        this.credit = 0;
    }

    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name);
        this.credit = credit;
    }

    public void setCredit(double credit) {
        if (credit > 0) {
            this.credit = credit;
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

    public double getCredit() {
        return credit;
    }

    @Override
    public void withdraw(double a) {
        if (a <= 0) {
        System.out.println("Input number must be a positive integer.");
        return;
        }
        if (a > 0) {
            double remaining = this.getBalance() - a;
            if (remaining >= 0) {
                this.setBalance(remaining);
                System.out.println(a + " baht is withdrawn from " + this.getName() + " and your credit balance is " + credit + ".");
            } else if (remaining + credit >= 0) {
                credit += remaining;
                this.setBalance(0);
                System.out.println(a + " baht is withdrawn from " + this.getName() + " and your credit balance is " + credit + ".");
            } else {
                System.out.println("Not enough money!");
            }
        }
    }

    public void withdraw(String a) {
        double number = Double.parseDouble(a);
        this.withdraw(number);
    }

    @Override
    public String toString() {
        return "The "+this.getName()+" account has "+this.getBalance()+" baht and "+credit+" credits.";
    }
}
