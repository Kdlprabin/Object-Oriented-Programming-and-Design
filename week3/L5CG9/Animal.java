package L5CG9;

public class Animal {
    private String name;

    // constructor
    public Animal(String name) {
        this.name = name;
    }

    // getter method
    public String getName() {
        return name;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Animal animal = new Animal("dog");
        System.out.println(animal.name);
    }
}