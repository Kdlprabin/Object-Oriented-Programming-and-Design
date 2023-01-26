import Database.CreateConnection;
import Database.CreateDatabase;
import Database.SupplyData;
import Frontend.Display;

import java.sql.SQLException;

public class Main {

    //to create and show GUI
    private static void createAndShowGUI(){
        try {
            new Display();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        new CreateDatabase();
        new SupplyData();
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}