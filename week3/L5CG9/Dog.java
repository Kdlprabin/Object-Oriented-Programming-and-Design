package L5CG9;

public class Dog extends Animal {
    private String color;

    public Dog(String name, String color) {
        super(name);
        this.color = color;
    }

    // getter method
    public String getColor() {
        return color;
    }

    // setter method
    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("rocky", "black");
    }
}
