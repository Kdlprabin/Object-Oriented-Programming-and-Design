package workshop3;

public class Dog extends Animal {
    private String color;

    // constructor
    public Dog(String color, String name, String category) {
        super(name, category);
        this.color = color;
    }

    // getter methods
    public String getColor() {
        return color;
    }

    // setter methods
    public void setColor(String color) {
        this.color = color;
    }
}
