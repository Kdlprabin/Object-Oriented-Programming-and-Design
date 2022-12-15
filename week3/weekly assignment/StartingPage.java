import java.util.Scanner;

@SuppressWarnings("unused")
public class StartingPage {
    private int command;

    // constructor
    public StartingPage() {

        while (this.command != 2) {// object of the scanner class
            Scanner scanner = new Scanner(System.in);

            // starting instructions
            System.out.println("Please enter 1 for Sign up. \nPlease enter 2 for Quit.");

            // taking up the command from the user
            this.command = scanner.nextInt();
            // checking the command given by the user
            checkCommand();
        }
    }

    public void checkCommand() {
        if (command == 1) {
            // sign in
            SignUp signUp = new SignUp();
        } else if(command == 2) {
            // Exit message
            System.out.println("Thank you for using the Application.\n");
        }
    }
}
