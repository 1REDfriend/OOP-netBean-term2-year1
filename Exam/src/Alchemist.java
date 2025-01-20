/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_30
 */
public class Alchemist extends Player{
    private double experience;
    
    public Alchemist(String name, double healthPoint, double energyPoint, double cash, String gender) {
        super(name, healthPoint, energyPoint, cash, gender);
        this.experience = 0;
    }
    
    public double getExperience() {
        return experience;
    }
    
    public void setExperience(double experience) {
        this.experience = experience;
    }
    
    public Potion craftPotion(String potionName) {
        if (potionName.equals("Health Point Medicine")) {
            if (this.getEnergyPoint() <= 50) {
                System.out.println(this.getName()+" is not enough the energy point.");
                return null;
            } else if (this.getEnergyPoint() > 50) {
                this.setEnergyPoint(this.getEnergyPoint() - 50);
                this.experience += 5;
                System.out.println(this.getName()+" has the energy point at "+this.getEnergyPoint()+" and the experience point at "+this.getExperience()+".");
                return new RedPotion(potionName);
            }
        } else if (potionName.equals("Energy Point Medicine")) {
            if (this.getEnergyPoint() <= 100) {
                System.out.println(this.getName()+" is not enough the energy point.");
                return null;
            } else if (this.getEnergyPoint() > 100) {
                this.setEnergyPoint(this.getEnergyPoint() - 100);
                this.experience += 8;
                System.out.println(this.getName()+" has the energy point at "+this.getEnergyPoint()+" and the experience point at "+this.getExperience()+".");
                return new BluePotion();
            }
        } else if (potionName.equals("High Health Point Medicine")) {
            if (this.getEnergyPoint() <= 150) {
                System.out.println(this.getName()+" is not enough the energy point.");
                return null;
            } else if (this.getEnergyPoint() > 150) {
                this.setEnergyPoint(this.getEnergyPoint() - 150);
                this.experience += 9;
                System.out.println(this.getName()+" has the energy point at "+this.getEnergyPoint()+" and the experience point at "+this.getExperience()+".");
                return new HiPotion();
            }
        }
        System.out.println("Incorrect Potion Name.");
        return null;
    }
    
    public Potion sell(Player p, String potionName) {
        if (potionName.equals("Health Point Medicine")) {
            if (p.getCash() < new RedPotion().getPrice()) {
                System.out.println(this.getName()+" is not enough money.");
                return null;
            } else if (p.getCash() >= new RedPotion().getPrice()) {
                p.setCash(p.getCash() - new RedPotion().getPrice());
                this.setCash(this.getCash() + new RedPotion().getPrice());
                return this.craftPotion(potionName);
            }
        } else if (potionName.equals("Energy Point Medicine")) {
            if (p.getCash() < new BluePotion().getPrice()) {
                System.out.println(this.getName()+" is not enough money.");
                return null;
            } else if (p.getCash() >= new BluePotion().getPrice()) {
                p.setCash(p.getCash() - new BluePotion().getPrice());
                this.setCash(this.getCash() + new BluePotion().getPrice());
                return this.craftPotion(potionName);
            }
        } else if (potionName.equals("High Health Point Medicine")) {
            if (p.getCash() < new HiPotion().getPrice()) {
                System.out.println(this.getName()+" is not enough money.");
                return null;
            } else if (p.getCash() >= new HiPotion().getPrice()) {
                p.setCash(p.getCash() - new HiPotion().getPrice());
                this.setCash(this.getCash() + new HiPotion().getPrice());
                return this.craftPotion(potionName);
            }
        }
        System.out.println("the potion name is incorrect.");
        return null;
    }
}
