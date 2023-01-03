package Exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(){
        super("This student is not available.");
    }
}
