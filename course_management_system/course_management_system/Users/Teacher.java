package Users;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Teacher extends User {

    private String username;
    private String password;
    private String email;
    private int contact;
    private String courseName;
    private String address;

    public Teacher(String password, String email) {
        super(password, email);
        // TODO Auto-generated constructor stub
    }
}
