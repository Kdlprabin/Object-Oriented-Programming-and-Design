package Backend.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User was not found");
    }
}
