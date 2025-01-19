/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public abstract class Spell {
    private final String name;
    private int damage;
    
    public Spell() {
        this.name = "";
        this.damage = 0;
    }
    
    public Spell(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
