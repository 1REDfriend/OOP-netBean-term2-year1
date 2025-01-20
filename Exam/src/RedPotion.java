/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_30
 */
public class RedPotion extends Potion{
    public RedPotion() {
        super("health Point Medicine");
    }
    
    public RedPotion(String name) {
        super(name);
    }
    
    @Override
    public double getPrice() {
        return 200.0;
    }
    
    @Override
    public String getInfo() {
        return "The HP medicine price "+this.getPrice()+" baht.";
    }
    
    @Override
    public void eat(Player p) {
        p.setHealthPoint(50);
    }
}
