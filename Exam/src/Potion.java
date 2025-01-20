/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_30
 */
public abstract class Potion implements Eatable {
    private final String name;
    
    public Potion(String name) {
        this.name = name;
    }
    
    public abstract String getInfo() ;
   
    public String getName() {
        return name;
    }
    
    public abstract double getPrice();
}
