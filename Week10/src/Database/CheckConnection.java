package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnection{

    void check(){
            String url = "jdbc:mysql://localhost?useSSL=false";
            String username = "root";
            String password = "Chitwannepal#4";
        //loading driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);
            if(!connection.isClosed()){
                System.out.println("Connection is opened");
            }
            System.out.println("connection failed");
            connection.close();
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        CheckConnection checkConnection = new CheckConnection();
        checkConnection.check();
    }
}
