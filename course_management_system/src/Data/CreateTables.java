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
        createStudentEnrollmentTable();
        createCourseInfoTable();
        createTeacherInfoTable();
        createModuleInfoTable();
        createStudentInfoTable();
        createEnrollmentTable();
        createOptionalEnrollmentTable();
    }
    private void createUserLoginTable() {
        try{
            Statement createTableUsersLogin = connection.createStatement();
            createTableUsersLogin.executeUpdate("CREATE TABLE IF NOT EXISTS USERS_LOGIN_DATA(ID int AUTO_INCREMENT PRIMARY KEY,ROLE VARCHAR(10),USERNAME VARCHAR(20),EMAIL VARCHAR(30),PASSWORD VARCHAR(15));");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    private void createCourseInfoTable(){
        try{
            Statement createTableCoursesInfo = connection.createStatement();
            createTableCoursesInfo.executeUpdate("CREATE TABLE IF NOT EXISTS COURSES_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,COURSE_NAME VARCHAR(20),COURSE_COST INT, ADDED_BY VARCHAR(20));");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    private  void createTeacherInfoTable(){
        try{
            Statement st = connection.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS TEACHER_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,TEACHER_NAME VARCHAR(50),COURSE_NAME VARCHAR(30),MODULE_NAME VARCHAR(50));");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    private void createModuleInfoTable()  {
        try{
            Statement createTableModuleInfo = connection.createStatement();
            createTableModuleInfo.executeUpdate("CREATE TABLE IF NOT EXISTS MODULES_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,MODULE_NAME VARCHAR(50),COURSE_NAME VARCHAR(30),TEACHER_NAME VARCHAR(30),MODULE_TYPE VARCHAR(50));");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    private void createStudentInfoTable(){
        try {
            Statement createTableStudentInfo = connection.createStatement();
            createTableStudentInfo.executeUpdate("CREATE TABLE IF NOT EXISTS STUDENT_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void createEnrollmentTable(){
        try {
            Statement createTableEnrollment = connection.createStatement();
            createTableEnrollment.executeUpdate("CREATE TABLE IF NOT EXISTS ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30),MODULE_NAME VARCHAR(50),MARKS_OBTAINED INT);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void createStudentEnrollmentTable(){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS STUDENT_ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30),MODULE_NAME VARCHAR(50),MODULE_TYPE VARCHAR(30), STATUS VARCHAR(30), MARKS_OBTAINED VARCHAR(100));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createOptionalEnrollmentTable(){
        try {
            Statement createTableOptionalEnrollment = connection.createStatement();
            createTableOptionalEnrollment.executeUpdate("CREATE TABLE IF NOT EXISTS OPTIONAL_ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30),OPTIONAL_MODULES VARCHAR(50),MARKS_OBTAINED INT);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
