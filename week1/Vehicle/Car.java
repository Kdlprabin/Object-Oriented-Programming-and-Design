package Vehicle;

public class Car {
    private String brand;
    private String color;
    private int mileage;
    private int year;
    private boolean hasFourWheels;

    // set the values
    public Car(String brand, String color, int mileage, boolean hasFourWheels,int year) {

        //separator
        for (int i = 0; i < 3; i++) {
            System.out.println("/////////////////////////////////////////");
        }
        this.brand = brand;
        this.color = color;
        this.mileage = mileage;
        this.hasFourWheels = hasFourWheels;
        this.year = year;
    }
    public void checkYear(){
        if(this.year <= 2010){
            System.out.println("the vehicle should not run");
        }else{
            System.out.println("The vehicle can run");
        }
    }

    // print the brand of the car
    public void printBrand() {
        System.out.println(this.brand);
    }

    public void increaseMileage() {
        this.mileage++;
    }

    public void decreaseMileage() {
        this.mileage--;
    }

    public void printAll() {
        System.out.println(this.brand);
        System.out.println(this.color);
        System.out.println(this.mileage);
        System.out.println(this.hasFourWheels);
    }

    public static void main(String[] args) {
        Car car = new Car("toyota", "red", 40, false,1998);
        car.checkYear();
    }
}
