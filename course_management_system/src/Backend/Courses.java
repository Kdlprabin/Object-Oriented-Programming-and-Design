package Backend;

import Data.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Courses {
    Database database = new Database();
    Connection connection = database.connectToDatabase();
    public ArrayList<String> getCourseList() {
        ArrayList<String> List = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * from COURSES_INFO;");
            while (res.next()) {
                List.add(res.getString("courseName"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }catch (NullPointerException E){
            System.out.println("The database is empty");
        }
        return List;
    }
    public  int getCourseCount(){
        int count = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT COUNT(*) FROM COURSE_INFO;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public int getModuleCount(){
        int count =0;
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT COUNT(*) FROM MODULES_INFO;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}