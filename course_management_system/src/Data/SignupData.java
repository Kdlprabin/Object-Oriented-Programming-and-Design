package Data;

import java.util.HashMap;

public class SignupData {
    String username= null;
    String email = null;
    String password = null;
    String role = null;


    public void addUsername(String username){
        this.username = username;
    }
    public void addPassword(String password){
        this.password = password;
    }
    public void addEmail(String email){
        this.email = email;
    }public void addRole(String role){
        this.role = role;
    }

}
