package Data;

import Backend.Exceptions.UserNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class FetchData {
    public HashMap<String, String> loginInfo = new HashMap<>();
    private final Database database = new Database("Login ");
    private Connection connection = database.connectToDatabase();

    public HashMap<String, String> loginData(String username) {
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM USERS_LOGIN_DATA WHERE USERNAME='" + username + "';");
            while (res.next()) {
                loginInfo.put("password", res.getString("PASSWORD"));
                loginInfo.put("role", res.getString("ROLE"));
            }
            loginInfo.put("username", username);
        } catch (NullPointerException e) {
            new CreateTables(connection);
        } catch (SQLException ex) {
            new CreateTables(connection);
            throw new UserNotFoundException();
        }finally {
            try {
                connection.close();
                System.out.println("login connection closed");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return loginInfo;
    }
}
