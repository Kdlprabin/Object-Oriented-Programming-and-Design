package Backend.Users;

import Data.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student{


    private String username;
    Database database = new Data.Database();
    Connection connection = database.connectToDatabase();
    private String[] optionalModules;


    public Student( String username){
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    private void chooseCourse(String courseName)throws SQLException {
        Statement chooseCourseSt = connection.createStatement();
        chooseCourseSt.executeUpdate("UPDATE STUDENT_INFO SET courseName='"+courseName+"' WHERE studentName='"+username+"';");
    }
    private void enrollModules(ArrayList<String> moduleName)throws  SQLException{
        Statement enrollModulesSt = connection.createStatement();
        for(String m:moduleName){
            enrollModulesSt.executeUpdate("INSERT INTO ENROLLMENT(studentName,moduleName)VALUES('" + username + "','" + m + "');");
        }
    }
    private ArrayList<String> getModuleInstructors(String moduleName)throws SQLException{
        ArrayList<String> instructors = new ArrayList<>();
        Statement getModuleInstructorsSt = connection.createStatement();
        ResultSet res = getModuleInstructorsSt.executeQuery("SELECT * FROM MODULES_INFO WHERE moduleName='"+moduleName+"';");
        while(res.next()){
            instructors.add(res.getString("teacherName"));
        }
        return instructors;
    }
    private void chooseOptionalModules(){}
}
