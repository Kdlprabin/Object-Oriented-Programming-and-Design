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
            createTable.executeUpdate("CREATE TABLE IF NOT EXISTS week10 (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `First_name` varchar(40) DEFAULT NULL,\n" +
                    "  `Last_name` varchar(40) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");");
            Statement dataSt = connection.createStatement();
            dataSt.executeUpdate("INSERT INTO `week10`(First_name,Last_name) VALUES ('Ram','Kaji'),('Manisha','Thapa'),('Adhish','shakya'),('Juja','Manander'),('Dewash','Phuyal'),('Nabin','Tako'),('Pratik','Dhakal'),('Ram','Kaji'),('Manisha','Thapa'),('Adhish','sakhya'),('Juja','manander'),('Diwash','Phuyal'),('Nabin','Tako'),('Pratik','Dhakal');\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public SupplyData() {
        CreateConnection connect = new CreateConnection();
        Connection connection = connect.con;
        putData(connection);
    }

}
