package Users;

import java.util.Dictionary;
import java.util.Scanner;

import Exception.LandlordNotFoundException;
import Exception.TenantNotFoundException;

public class Admin extends SystemUser {
    private String landLordInfo[][];
    private String tenantInfo[][];

    private String adminUsername = "admin";
    private String adminPassword = "admin123";

    public Admin() {
        login();
    }
    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username = scanner.next();
        System.out.println("Enter the password : ");
        String password = scanner.next();
        if (this.adminUsername.equals(username) && this.adminPassword.equals(password)) {
            System.out.println("!!! Login Successful !!!");
        }else{
            System.out.println("!!! Login Failed !!!\nUsername or Password not matching.");
        }

    }

    @Override
    public void logout() {
    }

    public void addLandlord(String property, String contact, String rentalCharge) {
        int length = this.landLordInfo.length;
        landLordInfo[length][0] = property;
        landLordInfo[length][1] = contact;
        landLordInfo[length][2] = rentalCharge;
    }

    public void deleteLandLord(String property) {
        for (int i = 0; i < tenantInfo.length; i++) {
            if (landLordInfo[i][0] == property) {
                landLordInfo[i] = null;
            } else {
                throw new LandlordNotFoundException();
            }
        }
    }

    public void addTenant(String name, String age, String mobileNumber, String identityProof, String address,
            String Dob) {
        int length = this.tenantInfo.length;
        tenantInfo[length][0] = name;
        tenantInfo[length][1] = age;
        tenantInfo[length][2] = mobileNumber;
        tenantInfo[length][3] = address;
        tenantInfo[length][4] = Dob;
    }

    public void deleteTenant(String name) {
        for (int i = 0; i < tenantInfo.length; i++) {
            if (tenantInfo[i][0] == name) {
                tenantInfo[i] = null;
            } else {
                throw new TenantNotFoundException();
            }
        }
    }

    public void generateReport(String name) {
        for (int i = 0; i < landLordInfo.length; i++) {
            if (landLordInfo[i][0] == name) {
                System.out.printf("The name of the landlord: %s", name);
                System.out.printf("The properties of landlord : %s", landLordInfo[i][1]);
                System.out.printf("The contact number of landlord : %s", landLordInfo[i][2]);
                System.out.printf("The rental charge of the landlord : %s", landLordInfo[i][3]);
            } else {
                throw new LandlordNotFoundException();
            }
        }
    }
}
