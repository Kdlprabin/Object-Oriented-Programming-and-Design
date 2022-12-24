package Users;

import java.util.Scanner;

public class StudentTypeTenant extends Tenant {
    public String username;
    public String password;

    @Override
    public void viewLandlord() {

    }

    @Override
    public void selectLandlord() {

    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username = scanner.next();
        System.out.println("Enter the password : ");
        String password = scanner.next();
        if (username != this.username && password != this.password) {
            System.out.println("The username or password invalid.");
        }
    }

    @Override
    public void logout() {

    }

    @Override
    public void leaveRentedRoom() {

    }

    @Override
    public void requestEmergencyPayment() {

    }

    @Override
    public void reviewLandlordBehavior() {

    }

    @Override
    public void reviewRentalProperty() {

    }

}