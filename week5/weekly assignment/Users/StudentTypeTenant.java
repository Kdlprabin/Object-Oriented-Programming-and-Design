package Users;

import java.util.Scanner;

public class StudentTypeTenant extends Tenant {
    public String username = "tenant";
    public String password = "tenant123";

    public StudentTypeTenant() {
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
            System.out.println(
                    "The commands for this system are:\n1- Request Emergency Payment\n2- Review Landlord Behavior\n3- Review Rental Property\n4- Leave Rented Property\n5- Logout");
            int command = 0;
            while (command != 5) {
                System.out.println("Enter the command: ");
                command = scanner.nextInt();
                switch (command) {
                    case 1:
                        requestEmergencyPayment();
                        break;
                    case 2:
                        reviewLandlordBehavior();
                        break;
                    case 3:
                        reviewRentalProperty();
                        break;
                    case 4:
                        leaveRentedRoom();
                        break;
                    case 5:
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