/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_30
 */
public class Swordman extends Player{
    public Swordman(String name,double healthPoint, double energyPoint, double cash, String gender) {
        super(name, healthPoint, energyPoint, cash, gender);
    }
    
    public Potion buy(Alchemist a, String potionName) {
        if (potionName.equals("Health Point Medicine") | potionName.equals("Energy Point Medicine") | potionName.equals("High Health Point Medicine")) {
            return a.sell(a, potionName);
        }
        System.out.println("The "+potionName+" does not found in the list.");
        return null;

    }
    
    public void fighting(Swordman s) {
        if (s.getEnergyPoint() < 20 ) {
            System.out.println(s.getName()+" is not enough the energy "+s.getEnergyPoint());
        } else {
            s.setHealthPoint(s.getHealthPoint() - 50);
            s.setEnergyPoint(s.getEnergyPoint() - 20);
            System.out.println(this.getName()+"("+this.getHealthPoint()+","+this.getEnergyPoint()+") fights with "+s.getName()+"("+s.getHealthPoint()+","+s.getEnergyPoint()+").");
        }
    }
    
    public void fighting(Swordman s, int round) {
        for (int i=1; i <= round ; i++) {
            if (s.getHealthPoint() > 0) {
                System.out.print("Round "+i+":");
                this.fighting(s);
            } else {
                System.out.println(s.getName()+" is zero HP.");
                break;
            }
        }
    }
}
