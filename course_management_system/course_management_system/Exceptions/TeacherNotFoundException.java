package Exceptions;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException() {
        super("This teacher is not available.");
    }
}
