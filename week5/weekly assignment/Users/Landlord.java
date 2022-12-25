package Users;

import java.util.Scanner;

public class Landlord extends SystemUser {

    private String property;
    private int contact;
    private float rentalCharge;
    private String username = "landlord";
    private String password = "landlord123";

    public Landlord(){
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
            System.out.println("!!! Login Successful !!!.");
        }else{
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
