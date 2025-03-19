
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB304_23
 */
public class Bfit implements Serializable {
    private int ID;
    private String type, detail;
    private String date;
    private double amount;
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
