package Users;

import java.util.Scanner;

@SuppressWarnings("unused")
public class User {
    private String password;
    private String email;

    public User(String password, String email) {
        login(email,password);
    }
    public void login(String email, String password) {
        //get email and password from the user
        if(this.email == email && this.password == password){
            System.out.println("Login Successful");
        }
    }

    public void logout() {
    }

    public void signup() {
        Scanner scanner = new Scanner(System.in);
        String username= scanner.next();
        String email = scanner.next();
        String password = scanner.next();

        // additional information  
        String contact = scanner.next();
        String address = scanner.next();
        String course = scanner.next();
    }
}
