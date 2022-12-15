package Question2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {

    //instance variables 
    private String email;
    private String password;

    //constructor
    public Validate() {

        //scanner class object to take input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the email : ");
        //email input
        this.email = scanner.nextLine();
        System.out.println("Please enter the password : ");
        //password input
        this.password = scanner.nextLine();
        System.out.println("The input values are not valid.");
    }

    //validate email
    public boolean validateEmail(){

        //email validation pattern
        String patternEmailString = "^[a-z0-9._%+-]+@heraldcollege.edu.np$";
        if(Pattern.matches(patternEmailString, email)){
            return true;
        }else{
            return false;
        }
    }

    //validate password
    public boolean validatePassword(){

        //password validation pattern
        String patternPasswordString = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).*$";
        if(Pattern.matches(patternPasswordString, password)){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        //object of the validate class
        Validate validate = new Validate();

        //checking the validity of the email
        if(validate.validateEmail()){
            System.out.println("The email is valid");
        }else{
            System.out.println("The email is not valid");
        }

        //checking the validity of the password
        if(validate.validatePassword()){
            System.out.println("The password is valid\n");
        }else{
            System.out.println("The password is not valid\n");
        }
    }
}

