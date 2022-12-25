package Users;

import java.util.Scanner;

public class StudentTypeTenant extends Tenant {
    public String username = "tenant";
    public String password = "tenant123";

    public StudentTypeTenant(){
        login();
    }
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
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("!!! Login Successful !!!.");
        }else{
            System.out.println("!!! Login Failed !!!\nUsername or Password not matching.");
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