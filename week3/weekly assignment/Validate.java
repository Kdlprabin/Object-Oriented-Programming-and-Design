import java.util.regex.Pattern;

//all the validation functions here
public class Validate {

    //name should contain more than 4 letters
    public boolean validateName(String name) {
        if (name.length() > 4) {
            return true;
        } else {
            return false;
        }
    }
    // the number should be of 10-digits and should start with 0
    public boolean validateContact(String contact) {
        if (contact.length() == 10 && contact.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }
    }

    //the password should be of minimum 8 length, should contain numbers at the end separating these with one special character
    public boolean validatePassword(String password) {
        String patternString = "^[A-Za-z]{4,20}+[~!@#$%^&*()_+][A-Za-z]*[0-9]+$";
        if (Pattern.matches(patternString, password)) {
            return true;
        } else {
            return false;
        }

    }

    //the password should match the conformation password
    public boolean validateCheckPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return true;
        } else {
            return false;
        }
    }

    //the date should not be younger than 21-years and should be in format DD/MM/YYYY OR MM/DD/YYYY
    public boolean validateDob(String dob) {
        String dateValidateString1 = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19[0-9][0-9]|20[0][1])$";
        String dateValidateString2 = "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])/(19[0-9][0-9]|20[0][1])$";
        if(Pattern.matches(dateValidateString1, dob) || Pattern.matches(dateValidateString2, dob)){
            return true;
        }else{
            return false;
        }
    }
}
