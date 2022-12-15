package Question1;
public class Mobile{

    //instance variables
    private String nameString;
    private String brandString;
    //constructor
    public Mobile(String nameString, String brandString) {
        this.nameString = nameString;
        this.brandString = brandString;
    }

    //constructor overloading
    public Mobile(String nameString){
        this.nameString = nameString;
    }
    //getter methods
    public String getName() {
        return nameString;
    }
    public String getBrand() {
        return brandString;
    }
    
    //setter methods 
    public void setName(String nameString){
        this.nameString = nameString;
    }
    public void setBrand(String brandString){
        this.brandString = brandString;
    }

    //method that cannot be updated
    final public void flashes(){
        System.out.println("The lights are on");
    }

    //method
    public void vibrates(){
        System.out.println(".......The mobile vibrates......");
    }

    //method overloading
    public void vibrates(String ringTone){
        System.out.println("......The mobile vibrates with ring tone.......");
    }
    
}