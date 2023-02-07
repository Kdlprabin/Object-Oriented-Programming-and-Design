package Backend;

import java.util.regex.Pattern;

public class Validate {

    public boolean validateUsername(String username) {
        return username.length() > 5 && username.contains(" ");
    }

    // validate email
    public boolean validateEmail(String email) {
        // email validation pattern
        String patternEmailString = "^[a-z0-9._%+-]+@gmail.com$";
        return Pattern.matches(patternEmailString, email);
    }

    // validate password
    public boolean validatePassword(String password) {
        // password validation pattern
        String patternPasswordString = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}$";
        return Pattern.matches(patternPasswordString, password);
    }
}
