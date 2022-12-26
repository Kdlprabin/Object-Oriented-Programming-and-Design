package Users;

import java.util.Scanner;

public class Landlord extends SystemUser {

    private String property;
    private int contact;
    private float rentalCharge;
    private String username = "landlord";
    private String password = "landlord123";

    public Landlord() {
        login();
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username = scanner.next();
        System.out.println("Enter the password : ");
        String password = scanner.next();
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("!!! Login Successful !!!.\n");
            System.out.println(
                    "The commands for this system are :\n1- View Tenants\n2- Count Tenants\n3- Add Bills\n4- Logout\n");
            int command = 0;
            while (command != 4) {
                System.out.println("Enter the command: ");
                command = scanner.nextInt();
                switch (command) {
                    case 1:
                        viewTenants();
                        break;
                    case 2:
                        countTenants();
                        break;
                    case 3:
                        addBills();
                        break;
                    case 4:
                        logout();
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("!!! Login Failed !!!\nUsername or Password not matching.");
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
