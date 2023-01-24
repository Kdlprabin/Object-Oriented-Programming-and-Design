package Backend.Interfaces;

import Data.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface UserInterface {
    Database database = new Database();
    Connection connection = database.connectToDatabase();
    static void Login(String username,String password){
        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM adminInfo;");
            while (res.next()){
                System.out.println(res.getString("username"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    static void Logout(){};
}
