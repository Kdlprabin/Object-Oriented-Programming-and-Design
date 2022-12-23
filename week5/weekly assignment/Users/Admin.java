package Users;

import java.util.Dictionary;
import java.util.Scanner;

public class Admin extends SystemUser{
    private String landLordInfo[][];
    private String tenantInfo[][];
    
    private String adminUsername = "admin";
    private String adminPassword = "admin123";
    
    @Override
    public void login() {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username : ");
        String username = scanner.next();
        System.out.println("Enter the password : ");
        String password = scanner.next();
        if( username != this.adminUsername && password != this.adminPassword){
            System.out.println("The username or password invalid.");
            
        }
        
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub
        
    }

    public void addLandlord(String property, String contact, String rentalCharge){
        int length = this.landLordInfo.length;
        landLordInfo[length][0] = property;
        landLordInfo[length][1] = contact;
        landLordInfo[length][2] = rentalCharge;
    }
    public void deleteLandLord(String property){
        for(int i = 0; i < tenantInfo.length; i++){
            if(landLordInfo[i][0] == property){
                landLordInfo[i] = null;
            }
        }
    }
    public void addTenant(String name, String age, String mobileNumber, String identityProof, String address, String Dob){
        int length = this.tenantInfo.length;
        tenantInfo[length][0] = name;
        tenantInfo[length][1] = age;
        tenantInfo[length][2] = mobileNumber;
        tenantInfo[length][3] = address;
        tenantInfo[length][4] = Dob;
    }
    public void deleteTenant(String name){
        for(int i = 0; i < tenantInfo.length; i++){
            if(tenantInfo[i][0] == name){
                tenantInfo[i] = null;
            }
        }
    }
}
