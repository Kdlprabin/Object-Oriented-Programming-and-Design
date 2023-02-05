package Backend.Exceptions;

public class NoTableFoundException extends RuntimeException{
    public NoTableFoundException() {
        super("The Respective table was not found.");
    }
}
