package Backend.AbstractClasses;

import java.util.Scanner;

public abstract class Users {
    Scanner scanner = new Scanner(System.in);
    String username = null;
    String password = null;
    private boolean login() {
        String realUsername = "user";
        String realPassword = "password";
        this.username = scanner.next();
        this.password = scanner.next();
        if(realPassword.equals(password) & realUsername.equals(username)){return true;}
            return false;
    }
    private void logout(){
        this.username = null;
        this.password = null;
    };
}
