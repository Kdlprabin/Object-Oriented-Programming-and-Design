package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public CreateDatabase(){
        CreateConnection connect = new CreateConnection();
        Connection connection = connect.con;
        try{
                Statement st = connection.createStatement();
                st.executeUpdate("CREATE DATABASE IF NOT EXISTS database_name;\n");
        }catch(SQLException e){
            System.out.println("SQL exception");
        }
    }
}
