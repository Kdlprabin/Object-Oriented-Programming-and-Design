package L5CG9;

import java.util.ArrayList;

public class Bike extends Vehicle {
    private int mileage;
    Engine engine;
    ArrayList<Engine> engines;

    // constructor
    public Bike(String name,
            int mileage,
            String brand,
            int regNumber,
            String chesisNumber,
            String colorString,
            String copNumber) {

        super(brand, regNumber, chesisNumber, colorString, copNumber);
        this.mileage = mileage;
        engine = new Engine();
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
