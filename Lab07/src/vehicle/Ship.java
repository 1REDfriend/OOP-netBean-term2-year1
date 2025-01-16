/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle;

/**
 *
 * @author tongt
 */
class Ship extends Vehicle implements Dieselable, Floatable {
    public Ship(double fuel) {
        super(fuel);
    }

    public Ship() {
        super();
    }

    @Override
    public void startEngine() {
        if (this.fuel >= 10) {
            this.fuel -= 10;
            System.out.println("Engine starts");
        } else {
            System.out.println("Fuel is not enough.");
        }
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stops");
    }

    @Override
    public void fl0at() {
        if (this.fuel >= 50) {
            this.fuel -= 50;
            System.out.println("Ship moves");
        } else {
            System.out.println("Fuel is not enough.");
        }
    }
    
    public void move() {
        this.fl0at();
    }

    public void move(int distance) {
        for (int i = 0; i < distance; i++) {
            if (this.fuel >= 50) {
                this.fl0at();
            } else {
                System.out.println("Fuel is not enough.");
                break;
            }
        }
    }

    @Override
    public void honk() {
        System.out.println("Shhhhh");
    }
}
