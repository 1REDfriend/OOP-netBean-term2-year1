/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB203_30
 */
public abstract class Player {
    private double cash;
    private double energyPoint;
    private char gender;
    private double healthPoint;
    private String name;
    private static int playerCount;
    private final String playerId;
    protected static final int MAX_PLAYERS = 5;
    
    public Player() {
        this.setCash(100.0);
        this.setEnergyPoint(10.0);
        this.setGender("male");
        this.setHealthPoint(10.0);
        this.setName("unknown");
        Player.playerCount += 1;
        this.playerId = this.name+"-"+Player.playerCount;
    }
    
    public Player(String name, String gender) {
        this.setName(name);
        this.setGender(gender);
        this.setCash(100.0);
        this.setEnergyPoint(10.0);
        this.setHealthPoint(10.0);
        Player.playerCount += 1;
        this.playerId = this.name+"-"+Player.playerCount;
    }
    
    public Player(String name, double healthPoint, double energyPoint, double cash, String gender) {
        this.setName(name);
        this.setGender(gender);
        this.setCash(cash);
        this.setEnergyPoint(energyPoint);
        this.setHealthPoint(healthPoint);
        Player.playerCount += 1;
        this.playerId = this.name+"-"+Player.playerCount;
    }
    
    public double getCash() {
        return cash;
    }
    
    public double getEnergyPoint() {
        return energyPoint;
    }
    
    public String getGender() {
        switch (gender) {
            case 'f' -> {
                return "female";
            }
            case 'm' -> {
                return "male";
            }
            default -> {
                return "male";
            }
        }
    }
    
    public double getHealthPoint() {
        return healthPoint;
    }
    
    public static int getMAX_PLAYERS() {
        return Player.MAX_PLAYERS;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static int getPlayerCount() {
        return Player.playerCount;
    }
    
    public String getPlayerId() {
        return this.playerId;
    }
    
    public void setCash(double cash) {
        this.cash = cash;
    }
    
    public void setEnergyPoint(double energyPoint) {
        if (energyPoint < 0) {
            System.out.println("Incorrect Input Energy Point.");
        } else {
            this.energyPoint = energyPoint;
        }
    }
    
    public void setGender(String gender) {
        if (gender.equals("Female") | gender.equals("female")) {
            this.gender = 'f';
        } else if (gender.equals("Male") | gender.equals("male")) {
            this.gender = 'm';
        }
    }
    
    public void setHealthPoint(double healthPoint) {
        if (healthPoint < 0) {
            System.out.println("Incorrect input Health Point.");
        } else {
            this.healthPoint = healthPoint;
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void drink(Eatable e) {
        if (e instanceof BluePotion bluePotion) {
            bluePotion.eat(this);
            System.out.println(this.getName()+" has the energy point medicine at "+this.getEnergyPoint());
        } else if (e instanceof RedPotion redPotion) {
            redPotion.eat(this);
            System.out.println(this.getName()+" has the health point medicine at "+this.getHealthPoint());
        } else if (e instanceof HiPotion hiPotion) {
            hiPotion.eat(this);
            System.out.println(this.getName()+" has the high health point medicine at "+this.getHealthPoint());
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) 
            return this.playerId.equals(obj);
        return false;
    }
    
    public boolean equals(Player obj) {
        return this.playerId.equals(obj.getPlayerId());
    }
    
    @Override
    public String toString() {
        return "name="+this.getName()+", healthPoint="+this.getHealthPoint()+", energyPoint="+this.getEnergyPoint()+", cash="+this.getCash()+", playerCount="+Player.getPlayerCount()+", MAX_PLAYERS="+Player.getMAX_PLAYERS()+", gender="+this.getGender()+", playerId="+this.getPlayerId()+".";
    }
}
