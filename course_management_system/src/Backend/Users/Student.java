package Backend.Users;

import Backend.AbstractClasses.Users;
import Data.Database;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student extends Users {
    private String username;
    Database database = new Data.Database();
    Connection connection = database.connectToDatabase();
    private String[] optionalModules;

    Student(String username){
        this.username = username;
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

    public static void main(String[] args) throws SQLException {
        Student student = new Student("Testing");
        student.chooseCourse("BIT");
        ArrayList<String> modules = new ArrayList<>();
        modules.add("NMC");
        modules.add("OOP");
        student.enrollModules(modules);
    }
}
