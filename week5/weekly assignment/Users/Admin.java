package Users;

import java.util.ArrayList;
import java.util.Scanner;
import Exception.LandlordNotFoundException;
import Exception.TenantNotFoundException;

public class Admin extends SystemUser {

    private ArrayList<String[]> landLordInfo = new ArrayList<>();
    private ArrayList<String[]> tenantInfo = new ArrayList<>();

    // dummy data for initial information
    private String[] landLord = { "Prabin", "Kathmandu", "9841265446", "5000" };
    private String[] tenant = { "Prabin", "20", "9841265446", "Citizenship", "Dhading", "2003-11-17" };

    //login username and password
    private String username = "admin";
    private String password = "admin123";

    public Admin() {
        login();
    }

    @Override
    public void login() {
        landLordInfo.add(this.landLord);
        tenantInfo.add(this.tenant);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username = scanner.next();
        System.out.println("Enter the password : ");
        String password = scanner.next();
        if (this.username.equals(username) && this.password.equals(password)) {
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
        for (String[] value : this.landLordInfo) {
            if (value[0].equals(name)) {
                landLordInfo.remove(value);
                return 0;
            }
        }
        throw new LandlordNotFoundException();
    }

    public void addTenant() {
        Scanner scanner = new Scanner(System.in);
        //data to add about tenant
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
        String[] info = { name, age, mobileNumber, identityProof, address, dob };
        tenantInfo.add(info);
    }

    public int deleteTenant() {
        Scanner scanner = new Scanner(System.in);
        //search tenant by name and delete information.
        System.out.println("Name: ");
        String name = scanner.next();
        for (String[] value : tenantInfo) {
            if (value[0].equals(name)) {
                tenantInfo.remove(value);
                return 0;
            }
        }
        //exception when tenant is not found.
        throw new TenantNotFoundException();
    }

    //generate a detail report of a landlord printed of a particular landlord by name.
    public int generateReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        for (String[] value : this.landLordInfo) {
            if (value[0].equals(name)) {
                System.out.printf("\nThe name of the landlord: %s\n", name);
                System.out.printf("The properties of landlord : %s\n", value[1]);
                System.out.printf("The contact number of landlord : %s\n", value[2]);
                System.out.printf("The rental charge of the landlord : %s\n", value[3]);
                return 0;
            }
        }
        //exception when landlord is not found
        throw new LandlordNotFoundException();
    }
}
