package Data;

import Backend.Exceptions.UserNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class FetchData {
    public HashMap<String,String> loginInfo= new HashMap<>();

    public HashMap<String,String> loginData(String username){
        Database database = new Database();
        Connection connection = database.connectToDatabase();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM USERS_LOGIN_DATA WHERE username='" + username + "';");
            while (res.next()) {
                loginInfo.put("password", res.getString("password"));
                loginInfo.put("role",res.getString("role"));
            }
            loginInfo.put("username", username);
        }catch(NullPointerException e){
            new CreateTables(connection);
        }catch(SQLException ex){
            new CreateTables(connection);
            throw new UserNotFoundException();
        }
        return loginInfo;
    }
}
