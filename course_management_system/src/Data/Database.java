package Data;

import java.sql.*;

public class Database {

    public Database(){
        createAdmin(connectToDatabase());
    }
    private Connection loadDriver(String url, String username, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (!connection.isClosed()) {
                System.out.println("Connection successful");
                //creating all the required tables
                Statement createTableUsersLogin = connection.createStatement();
                Statement createTableCoursesInfo = connection.createStatement();
                Statement createTableModuleInfo = connection.createStatement();
                Statement createTableStudentInfo = connection.createStatement();
                Statement createTableEnrollment = connection.createStatement();
                Statement createTableOptionalEnrollment = connection.createStatement();
                createTableUsersLogin.executeUpdate("CREATE TABLE IF NOT EXISTS USERS_LOGIN_DATA(id int AUTO_INCREMENT PRIMARY KEY,role VARCHAR(10),username VARCHAR(20),email VARCHAR(30),password VARCHAR(15));");
                createTableCoursesInfo.executeUpdate("CREATE TABLE IF NOT EXISTS COURSES_INFO(id INT AUTO_INCREMENT PRIMARY KEY,courseName VARCHAR(20),courseDescription VARCHAR(100),courseCost INT, moduleList VARCHAR(100), addedBy VARCHAR(20));");
                createTableModuleInfo.executeUpdate("CREATE TABLE IF NOT EXISTS MODULES_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,moduleName VARCHAR(50),courseName VARCHAR(30),teacherName VARCHAR(30));");
                createTableStudentInfo.executeUpdate("CREATE TABLE IF NOT EXISTS STUDENT_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,studentName VARCHAR(30),courseName VARCHAR(30));");
                createTableEnrollment.executeUpdate("CREATE TABLE IF NOT EXISTS ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,studentName VARCHAR(30),moduleName VARCHAR(30),marksObtained INT);");
                createTableOptionalEnrollment.executeUpdate("CREATE TABLE IF NOT EXISTS OPTIONAL_ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,studentName VARCHAR(30),optionalModuleName VARCHAR(30),marksObtained INT);");
            }
            return connection;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class was not found");
        }catch(NullPointerException e){
            createDatabase("jdbc:mysql://localhost/",username,password);
        }catch(SQLException e){
            createDatabase("jdbc:mysql://localhost/",username,password);
        }
        return null;
    }
    public void createAdmin(Connection connection) {
        String admin= "";
        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM USERS_LOGIN_DATA WHERE ROLE='admin';");
            while (res.next()){
                admin = res.getString("username");
            }
            if(admin == ""){
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO USERS_LOGIN_DATA(role,username,password)VALUES('ADMIN','ADMIN','ADMIN');");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void createDatabase(String url, String username,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (!connection.isClosed()) {
                System.out.println("Connection successful");
                Statement st = connection.createStatement();
                st.executeUpdate("CREATE DATABASE IF NOT EXISTS course_management_system;");
            }
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    public Connection connectToDatabase(){
        String url = "jdbc:mysql://localhost/course_management_system";
        String username = "root";
        String password = "Chitwannepal#4";
        Connection connection = loadDriver(url,username,password);
        return connection;
    }

    public static void main(String[] args) {
        Database database = new Database();
    }
}
