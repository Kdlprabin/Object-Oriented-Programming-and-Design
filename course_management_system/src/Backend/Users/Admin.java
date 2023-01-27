package Backend.Users;

import Backend.Interfaces.UserInterface;
import Data.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Admin implements UserInterface {

    private String username;
    //constructor
    public Admin(String username){
        this.username = username;
    }
    private Database database = new Database();
    private Connection connection =database.connectToDatabase();

    public void addCourse(String courseName, String courseDescription,int courseCost, String[] moduleList) throws SQLException {
        //convert the list of modules into a single string
        String moduleListString = "";
        for(int i =0;i<moduleList.length;i++){
            moduleListString+= moduleList[i];
            moduleListString+= " ";
        }
        Statement addCourseSt = connection.createStatement();
        addCourseSt.executeUpdate("INSERT INTO COURSES_INFO(courseName,courseDescription,courseCost,moduleList,addedBy) VALUES ('"+courseName+"', '"+courseDescription+"', "+courseCost+",'"+moduleListString+"','"+username+"');");
    }
    public void addModule(String courseName)throws  SQLException{
        Statement updateModuleSt = connection.createStatement();
        updateModuleSt.executeUpdate("");
    }
    public void deleteCourse(String courseName)throws  SQLException{
        Statement deleteCourseSt = connection.createStatement();
        deleteCourseSt.executeUpdate("");
    }
    public void updateCourse(String courseName)throws SQLException{
        Statement updateCourseSt = connection.createStatement();
        updateCourseSt.executeUpdate("");
    }
    public void generateResult(String studentName) throws  SQLException{
        Statement generateResultSt = connection.createStatement();
        generateResultSt.executeUpdate("");
    }

//    public static void main(String[] args) throws SQLException {
//        Admin admin = new Admin("Prabin");
//        String[] moduleList = {"NMC", "OOP"};
//        admin.addCourse("BIT","IT with more practical workshops",800000,moduleList);
//    }
}
