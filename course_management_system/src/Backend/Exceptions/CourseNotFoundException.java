package Backend.Exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(){
        super("Course not found");
    }
}
