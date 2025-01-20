/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_30
 */
public class HiPotion extends RedPotion{
    public HiPotion() {
        super("High Health Point Medicine");
    }
    
    @Override
    public double getPrice() {
        return 500.0;
    }
    
    @Override
    public String getInfo() {
        return "The HiHP medicine price "+this.getPrice()+" baht.";
    }
    
    @Override
    public void eat(Player p) {
        p.setHealthPoint(500);
    }
}
