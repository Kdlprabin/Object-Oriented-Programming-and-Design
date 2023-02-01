package Data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//create all the required tables for the system
public class CreateTables {
    //instance variable to store the database connection
    private Connection connection;
    public CreateTables(Connection connection) {
        //pass connection to instance variable
        this.connection = connection;
        //creating tables
        createUserLoginTable();
        createCourseInfoTable();
        createModuleInfoTable();
        createStudentInfoTable();
        createEnrollmentTable();
        createOptionalEnrollmentTable();
    }
    private void createUserLoginTable(){
        try{
            Statement createTableUsersLogin = connection.createStatement();
            createTableUsersLogin.executeUpdate("CREATE TABLE IF NOT EXISTS USERS_LOGIN_DATA(id int AUTO_INCREMENT PRIMARY KEY,role VARCHAR(10),username VARCHAR(20),email VARCHAR(30),password VARCHAR(15));");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    private void createCourseInfoTable(){
        try{
            Statement createTableCoursesInfo = connection.createStatement();
            createTableCoursesInfo.executeUpdate("CREATE TABLE IF NOT EXISTS COURSES_INFO(id INT AUTO_INCREMENT PRIMARY KEY,courseName VARCHAR(20),courseDescription VARCHAR(100),courseCost INT, moduleList VARCHAR(100), addedBy VARCHAR(20));");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    private void createModuleInfoTable()  {
        try{
            Statement createTableModuleInfo = connection.createStatement();
            createTableModuleInfo.executeUpdate("CREATE TABLE IF NOT EXISTS MODULES_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,moduleName VARCHAR(50),courseName VARCHAR(30),teacherName VARCHAR(30));");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    private void createStudentInfoTable(){
        try {
            Statement createTableStudentInfo = connection.createStatement();
            createTableStudentInfo.executeUpdate("CREATE TABLE IF NOT EXISTS STUDENT_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,studentName VARCHAR(30),courseName VARCHAR(30));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void createEnrollmentTable(){
        try {
            Statement createTableEnrollment = connection.createStatement();
            createTableEnrollment.executeUpdate("CREATE TABLE IF NOT EXISTS ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,studentName VARCHAR(30),moduleName VARCHAR(30),marksObtained INT);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createOptionalEnrollmentTable(){
        try {
            Statement createTableOptionalEnrollment = connection.createStatement();
            createTableOptionalEnrollment.executeUpdate("CREATE TABLE IF NOT EXISTS OPTIONAL_ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,studentName VARCHAR(30),optionalModuleName VARCHAR(30),marksObtained INT);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
