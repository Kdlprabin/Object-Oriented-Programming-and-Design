package Backend.CustomDatatype;

public class UserData {
    private String username;
    private String role;
    private String course;

    public UserData(String username, String role, String course) {
        this.username = username;
        this.role = role;
        this.course = course;
    }


    public UserData(String username) {
        this.username = username;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
