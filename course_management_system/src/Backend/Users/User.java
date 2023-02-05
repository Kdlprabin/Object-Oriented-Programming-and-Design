package Backend.Users;

import Data.Database;

import java.sql.Connection;

public class User {
    public String username;
    public String role;
    Database database = new Database();
    private final Connection connection = database.connectToDatabase();
}
