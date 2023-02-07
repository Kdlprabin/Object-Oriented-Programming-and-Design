package Backend.Users;

import Data.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public abstract class User {

    public String username;
    public String email;
    private final Database database = new Database("User ");
    public Connection connection = database.connectToDatabase();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM USERS_LOGIN_DATA WHERE USERNAME='" + username + "';");
            while (res.next()) {
                this.email = res.getString("EMAIL");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Integer> getCounts() {
        String studentQuery = "SELECT COUNT(*) FROM STUDENT_INFO;";
        String teacherQuery = "SELECT COUNT(*) FROM TEACHER_INFO;";
        String courseQuery = "SELECT COUNT(*) FROM COURSES_INFO;";
        String moduleQuery = "SELECT COUNT(*) FROM MODULES_INFO;";
        HashMap<String, Integer> data = new HashMap<>();
        try {
            Statement studentSt = connection.createStatement();
            Statement teacherSt = connection.createStatement();
            Statement courseSt = connection.createStatement();
            Statement moduleSt = connection.createStatement();

            ResultSet student = studentSt.executeQuery(studentQuery);
            ResultSet teacher = teacherSt.executeQuery(teacherQuery);
            ResultSet course = courseSt.executeQuery(courseQuery);
            ResultSet module = moduleSt.executeQuery(moduleQuery);

            while (student.next()) {
                data.put("student", student.getInt(1));
            }
            while (teacher.next()) {
                data.put("teacher", teacher.getInt(1));
            }
            while (course.next()) {
                data.put("course", course.getInt(1));
            }
            while (module.next()) {
                data.put("module", module.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public void logout(){
        this.username = null;
        this.email = null;
        try {
            this.connection.close();
            System.out.println("user connection closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
