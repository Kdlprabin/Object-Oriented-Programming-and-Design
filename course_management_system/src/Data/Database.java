package Data;

import java.sql.*;
import java.util.Objects;

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
                new CreateTables(connection);
            }
            return connection;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class was not found");
        }catch(NullPointerException | SQLException e){
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
            if(Objects.equals(admin, "")){
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO USERS_LOGIN_DATA(role,username,password)VALUES('ADMIN','ADMIN','ADMIN');");
            }
        }catch (SQLException e){
            new CreateTables(connection);
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
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
    public Connection connectToDatabase(){
        String url = "jdbc:mysql://localhost/course_management_system";
        String username = "root";
        String password = "Chitwannepal#4";
        return loadDriver(url,username,password);
    }

}
