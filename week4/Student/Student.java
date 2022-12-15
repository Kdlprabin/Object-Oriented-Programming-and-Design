package Student;

public class Student{
    private String name;
    private int stdId;
    private String groupName;

    //constructor
    //constructor overloading 
    public Student(String name, int stdId){
        this.name = name;
        this.stdId = stdId;
    }
    public Student(String name, int stdId, String groupName){
        this.name = name;
        this.stdId = stdId;
        this.groupName = groupName;
    }

    //getter methods
    public String getName(){
        return name;
    }
    public int getStdId(){
        return stdId;
    }

    //setter methods
    public void setName(String name){
        this.name = name;
    }
    public void setStdId(int stdId){
        this.stdId = stdId;
    }

    //Method overloading
    public void printProvided(){
        System.out.println("This method doesnt take any arguments");
    }
    public void printProvided(String value){
        System.out.println("This is a string");
        System.out.println(value);
    }
    public void printProvided(int value){
        System.out.println("This is a integer");
        System.out.println(value);
    }

    public void printProvided(int value, String strValue){
        System.out.println("Here is int first and string second");
        System.out.println(value);
        System.out.println(strValue);
    }
    public void printProvided(String strValue, int value){
        System.out.println("Here string first and int second");
        System.out.println(value);
        System.out.println(strValue);
    }
}