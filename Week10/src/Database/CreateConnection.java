package Database;

import java.sql.*;

public class CreateConnection{
    Connection con;
    public CreateConnection(){
            String url = "jdbc:mysql://localhost/week10";
            String username = "root";
            String password = "Chitwannepal#4";
        //loading driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,username,password);
            if(!connection.isClosed()){
                System.out.println("Connection is opened");
                this.con = connection;
            }else {
                System.out.println("connection failed");
            }
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
}
