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

    public Student(String username){
        this.username = username;
    }
    public Student(){}
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

    public int getStudentsCount(){
        int studentCount = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT COUNT(*) FROM USERS_LOGIN_DATA WHERE ROLE='Student';");
        }catch (SQLException e){
            System.out.println("SQL Exception");
        }
        return studentCount;
    }
}
