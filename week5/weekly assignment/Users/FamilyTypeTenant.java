package Users;

import java.util.Scanner;

public class FamilyTypeTenant extends Tenant {
    // login username and password
    private String username = "tenant";
    private String password = "tenant123";
    private String[] landLords = { "Prabin", "Pradeep", "Bishnu" };
    private String myLandlord = "Prabin";

    public FamilyTypeTenant() {
        login();
    }

    @Override
    public void viewLandlord() {
        System.out.println("Landlord Name : " + this.myLandlord);
    }

    @Override
    public void selectLandlord() {
        System.out.println("The list of landlord to choose from : \n");
        for (String landlord : landLords) {
            System.out.println(landlord);
        }
        Scanner scanner = new Scanner(System.in);

        this.myLandlord = scanner.next();

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
        System.out.println("I want to leave the rented room.");
    }

    @Override
    public void requestEmergencyPayment() {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();  
        System.out.println("I request the emergency payment amount of :"+amount);
    }

    @Override
    public void reviewLandlordBehavior() {
        System.out.println("The landlord behavior of "+myLandlord+" is printed.");
    }

    @Override
    public void reviewRentalProperty() {
        System.out.println("The Rental Property details is printed.");
    }

}