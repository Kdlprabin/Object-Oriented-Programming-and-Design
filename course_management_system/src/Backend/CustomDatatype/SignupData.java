package Backend.CustomDatatype;

public class SignupData {
    public String username;
    public String email;
    public String password;
    public String role;

    public SignupData(String username, String email,String role, String password){
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public void addData(String username,String email,String role,String password){
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
