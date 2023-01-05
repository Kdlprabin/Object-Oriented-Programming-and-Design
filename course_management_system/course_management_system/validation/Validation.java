package validation;
import java.util.regex.Pattern;

public class Validation {
    private String email;
    private String password;
    public boolean validateEmail(){
        String patternEmailString = "^[a-z0-9._%+-]+@heraldcollege.edu.np$";
        if (Pattern.matches(patternEmailString, email)) {
            return true;

        }
        return false;
    }
    public boolean validatePassword(){
        String patternPasswordString = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).*$";
        if (Pattern.matches(patternPasswordString, password)) {
            return true;
        }
        return false;
    }
}
