package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class SupplyData {

    private void putData(Connection connection){
        try{
            Statement select = connection.createStatement();
            select.executeUpdate("USE week10;");
            Statement createTable = connection.createStatement();
            createTable.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS week10 (
                      `id` int NOT NULL AUTO_INCREMENT,
                      `First_name` varchar(40) DEFAULT NULL,
                      `Last_name` varchar(40) DEFAULT NULL,
                      PRIMARY KEY (`id`)
                    );""");
            Statement dataSt = connection.createStatement();
            dataSt.executeUpdate("INSERT INTO `week10`(First_name,Last_name) VALUES ('Ram','Kaji'),('Manisha','Thapa'),('Adhish','shakya'),('Juja','Manander'),('Dewash','Phuyal'),('Nabin','Tako'),('Pratik','Dhakal'),('Ram','Kaji'),('Manisha','Thapa'),('Adhish','sakhya'),('Juja','manander'),('Diwash','Phuyal'),('Nabin','Tako'),('Pratik','Dhakal');\n");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public SupplyData() throws SQLException {
        CreateConnection connect = new CreateConnection();
        Connection connection = connect.con;
        putData(connection);
    }

}
