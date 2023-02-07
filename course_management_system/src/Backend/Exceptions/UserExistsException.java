package Backend.Exceptions;

public class UserExistsException extends RuntimeException {
    public UserExistsException() {
        super("The user already exists in the Database");
    }
}
