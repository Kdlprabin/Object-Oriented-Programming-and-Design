package L5CG9;

public class Vehicle {
    String brand;
    int regNumber;
    private String chesisNumber;
    protected String colorString;
    public String copNumber;

    // Constructor
    public Vehicle(
            String brand,
            int regNumber,
            String chesisNumber,
            String colorString,
            String copNumber) {

        // initializing
        this.brand = brand;
        this.regNumber = regNumber;
        this.chesisNumber = chesisNumber;
        this.colorString = colorString;
        this.copNumber = copNumber;

    }

    // getter methods
    public String getChesisNumber() {
        return this.chesisNumber;
    }
    // setter methods
    public void setChesisNumber(String chesisNumber) {
        this.chesisNumber = chesisNumber;
    }
}
