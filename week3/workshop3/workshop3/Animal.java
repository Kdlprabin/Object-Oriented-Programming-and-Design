package workshop3;

public class Animal {
    private String name;
    private String category;

    // constructor
    public Animal(String name, String category) {
        this.name = name;
        this.category = category;
    }

    // getter methods
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
