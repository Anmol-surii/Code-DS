package LLD.StrategyDesign;

import LLD.StrategyDesign.Strategy.DriveStrategy;

public class Vehicle {
    private final DriveStrategy driveObj;

    // Constructor Injection
    public Vehicle(DriveStrategy s) {
        this.driveObj = s;
    }

    public void drive() {
        driveObj.drive();
    }
}
