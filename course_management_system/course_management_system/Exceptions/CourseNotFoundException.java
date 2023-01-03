package Exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("This course is not available.");
    }

}
