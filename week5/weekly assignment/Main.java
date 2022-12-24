import java.util.Scanner;

import Users.Admin;
import Users.FamilyTypeTenant;
import Users.Landlord;
import Users.StudentTypeTenant;

public class Main {
    private String role;
    private String[] Roles = { "admin", "tenant", "landlord" };

    public Main() {
        boolean checker = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Role : ");
        this.role = scanner.next();
        for (int i = 0; i < Roles.length; i++) {
            if (Roles[i].equals(role.toLowerCase())) {
                checker = true;
                role = Roles[i];
                break;
            }
        }
        if (checker) {
            System.out.printf("Welcome %s!", role);
            switch (role) {
                case "admin":
                    Admin admin = new Admin();
                    break;
                case "tenant":
                    System.out.println(
                            "Enter the type of tenant you are: \n1 for family type tenant.\n2 for Student type tenant.");
                    int type = scanner.nextInt();
                    if (type == 1) {
                        FamilyTypeTenant tenant = new FamilyTypeTenant();
                    } else if (type == 2) {
                        StudentTypeTenant tenat = new StudentTypeTenant();
                    } else {
                        System.out.println("Please enter a valid input.");
                    }
                case "landlord":
                    Landlord landlord = new Landlord();
                    break;
                default:
                    break;
            }

        } else {
            System.out.printf("The role (%s) is not available in our system.", role);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
