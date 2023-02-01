package Backend.CustomDatatype;

public class SignupData {
    public String username= null;
    public String email = null;
    public String password = null;
    public String role = null;

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
