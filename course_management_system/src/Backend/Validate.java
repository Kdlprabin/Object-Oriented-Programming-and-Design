package Backend;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {

    //validate email
    public boolean validateEmail(String email){

        //email validation pattern
        String patternEmailString = "^[a-z0-9._%+-]+@heraldcollege.edu.np$";
        if(Pattern.matches(patternEmailString, email)){
            return true;
        }else{
            return false;
        }
    }

    //validate password
    public boolean validatePassword(String password){

        //password validation pattern
        String patternPasswordString = "^.*(?=.{10,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        if(Pattern.matches(patternPasswordString, password)){
            return true;
        }else{
            return false;
        }
    }
}

