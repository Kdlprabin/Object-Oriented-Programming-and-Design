package Users;

import java.util.ArrayList;
import java.util.Scanner;
import Exception.LandlordNotFoundException;
import Exception.TenantNotFoundException;

public class Admin extends SystemUser {

    private ArrayList<String[]> landLordInfo = new ArrayList<>();
    private ArrayList<String[]> tenantInfo = new ArrayList<>();

    // initial information
    private String[] landLord1 = { "Prabin", "Lalitpur", "9841265446", "5000" };
    private String[] tenant1 = { "Prabin", "20", "9841265446", "Passport", "Dhading", "2003-11-17" };

    private String adminUsername = "admin";
    private String adminPassword = "admin123";

    public Admin() {
        login();
    }

    @Override
    public void login() {
        landLordInfo.add(this.landLord1);
        tenantInfo.add(this.tenant1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username = scanner.next();
        System.out.println("Enter the password : ");
        String password = scanner.next();
        if (this.adminUsername.equals(username) && this.adminPassword.equals(password)) {
            System.out.println("!!! Login Successful !!!\n");
            System.out.println(
                    "The commands for this system are :\n1- Add Landlord\n2- Add Tenant\n3- Delete Landlord\n4- Delete Tenant\n5- Generate Landlord Report\n6- Logout");
            int command = 0;
            while (command != 6) {
                System.out.println("Enter the command: ");
                command = scanner.nextInt();
                switch (command) {
                    case 1:
                        addLandlord();
                        break;
                    case 2:
                        addTenant();
                        break;
                    case 3:
                        deleteLandLord();
                        break;
                    case 4:
                        deleteTenant();
                        break;
                    case 5:
                        generateReport();
                        break;
                    case 6:
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

    public void addLandlord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Property: ");
        String property = scanner.next();
        System.out.println("Contact: ");
        String contact = scanner.next();
        System.out.println("Rental Charge: ");
        String rentalCharge = scanner.next();
        String[] info = { name, property, contact, rentalCharge };
        landLordInfo.add(info);
    }

    public int deleteLandLord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        for (int i = 0; i < this.landLordInfo.size(); i++) {
            if (landLordInfo.get(i)[0].equals(name)) {
                landLordInfo.remove(i);
                return 0;
            }
        }
        throw new LandlordNotFoundException();
    }

    public void addTenant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Age: ");
        String age = scanner.next();
        System.out.println("Mobile Number: ");
        String mobileNumber = scanner.next();
        System.out.println("Identity Proof: ");
        String identityProof = scanner.next();
        System.out.println("Address: ");
        String address = scanner.next();
        System.out.println("Date of Birth: ");
        String dob = scanner.next();
        int length = this.tenantInfo.size();
        String[] info = { name, age, mobileNumber, identityProof, address, dob };
        tenantInfo.add(info);
    }

    public int deleteTenant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        for (int i = 0; i < tenantInfo.size(); i++) {
            if (tenantInfo.get(i)[0].equals(name)) {
                tenantInfo.remove(i);
                return 0;
            }
        }
        throw new TenantNotFoundException();
    }

    public int generateReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        for (int i = 0; i < this.landLordInfo.size(); i++) {
            if (landLordInfo.get(i)[0].equals(name)) {
                System.out.printf("\nThe name of the landlord: %s\n", name);
                System.out.printf("The properties of landlord : %s\n", landLordInfo.get(i)[1]);
                System.out.printf("The contact number of landlord : %s\n", landLordInfo.get(i)[2]);
                System.out.printf("The rental charge of the landlord : %s\n", landLordInfo.get(i)[3]);
                return 0;
            }
        }
        throw new LandlordNotFoundException();
    }
}
