package Backend;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {

    public boolean validateUsername(String username){
        if(username.length() > 5& !username.contains(" ")){
            return true;
        }
        return false;
    }

    //validate email
    public boolean validateEmail(String email){
        //email validation pattern
        String patternEmailString = "^[a-z0-9._%+-]+@gmail.com$";
        if(Pattern.matches(patternEmailString, email)){
            return true;
        }
        return false;

    }

    //validate password
    public boolean validatePassword(String password){
        //password validation pattern
        String patternPasswordString = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}$";
        if(Pattern.matches(patternPasswordString, password)){
            return true;
        }
            return false;
    }
}

