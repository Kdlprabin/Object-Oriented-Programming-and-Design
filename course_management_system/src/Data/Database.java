package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection loadDriver(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (!connection.isClosed()) {
                System.out.println("Connection successful");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class was not found");
        }
        return null;
    }
    public Connection connectToDatabase(){
        String url = "jdbc:mysql://localhost/course_management_system";
        String username = "root";
        String password = "Chitwannepal#4";
        Connection connection = loadDriver(url,username,password);
        return connection;
    }
}
