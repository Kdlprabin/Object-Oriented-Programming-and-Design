package Users;

import java.util.Scanner;

public class Landlord extends SystemUser {

    private String property;
    private int contact;
    private float rentalCharge;
    private String landLordUsername;
    private String landLordPassword;

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username = scanner.next();
        System.out.println("Enter the password : ");
        String password = scanner.next();
        if (username != this.landLordUsername && password != this.landLordPassword) {
            System.out.println("The username or password invalid.");
        }
    }

    @Override
    public void logout() {

    }

    public void viewTenants() {

    }

    public void addBills() {
    }

    public void countTenants() {
    }

}
