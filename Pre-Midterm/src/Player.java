/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEXR
 */
public class Player {

    private final String name;
    private final int attackDamage = 2;
    private Houses houses;
    private int hp = 20;
    private int mana = 50;

    public Player() {
        this.name = "";
        this.houses = null;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.hp;
    }

    public void setHP(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > 20) {
            this.hp = 20;
        } else {
            this.hp = hp;
        }
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            this.mana = 0;
        } else if (mana > 50) {
            this.mana = 50;
        } else {
            this.mana = mana;
        }
    }

    public Houses getHouses() {
        return this.houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "[Player] : " + name + " HP: " + hp + " Mana: " + mana + " || " + houses;
    }

    public boolean equals(Player player) {
        return ((this.name == null ? player.name == null : this.name.equals(player.name)) && this.houses == houses);
    }

    public void attack(Player target, Spell spell) {
        if (houses instanceof Hufflepuff hufflepuff) {
            hufflepuff.attckSpell(this, target, spell);
        } else if (houses instanceof Gryffindor gryffindor) {
            gryffindor.attckSpell(this, target, spell);
        }
        if (target.getHP() <= 0) {
            System.out.println("[DEAD]: " + target.getName() + " was killed by " + name);
        }
    } 

    public void protectFromPlayer(Player target) {
        if (this.houses instanceof Hufflepuff) {
            ((Hufflepuff) houses).defence(this, target);
        } else if (this.houses instanceof Gryffindor) {
            ((Gryffindor) houses).defence(this, target);
        }
    }
}
