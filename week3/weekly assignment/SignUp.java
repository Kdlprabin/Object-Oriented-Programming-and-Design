import java.util.Scanner;

public class SignUp {
    private String name;
    private String contact;
    private String password;
    private String confirmPassword;
    private String dob;
    private String[] data;

    // constructor
    public SignUp() {
        Scanner scanner1 = new Scanner(System.in);
        printMessage("full name");
        this.name = scanner1.nextLine();
        printMessage("mobile number (username)");
        this.contact = scanner1.next();
        printMessage("password");
        this.password = scanner1.next();
        printMessage("confirm", "password");
        this.confirmPassword = scanner1.next();
        printMessage("Date fo Birth #DD/MM/YYYY (No space)");
        this.dob = scanner1.next();
        validateAll();
    }

    private void saveData() {
        this.data[0] = this.name;
        this.data[1] = this.contact;
        this.data[2] = this.password;
        this.data[3] = this.dob;
    }

    public void validateAll() {
        Validate validate = new Validate();
        boolean valName = validate.validateName(this.name);
        boolean valContact = validate.validateContact(this.contact);
        boolean valPassword = validate.validateCheckPassword(this.password, this.confirmPassword);
        boolean valPasswordMatch = validate.validatePassword(this.password);
        if (valName && valPassword && valContact && valPasswordMatch) {
            System.out.println("You have successfully signed up.\n");
            // save the data of the user
            saveData();

        } else {
            System.out.println("Some of the input fields are not valid.\n");
            if (!valName) {
                System.out.println("Your name must have more than 4 letters.\nPlease start again.");
            }
            if (!valContact) {
                System.out.println("Your contact number is invalid.\nPlease start again.");
            }
            if (!valPassword) {
                System.out.println("Your passwords are not matching.\nPlease start again.");
            }
            if (!valPasswordMatch) {
                System.out.println("Your password does not matches the format");
            }
        }

    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // method overloading
    public void printMessage(String message) {
        System.out.println("Please enter your " + message + " : ");
    }

    public void printMessage(String message1, String message2) {
        System.out.println("Please " + message1 + " your " + message2 + " : ");
    }
}
