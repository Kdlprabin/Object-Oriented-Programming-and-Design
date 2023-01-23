import Database.CreateConnection;
import Frontend.Display;

import java.sql.Connection;

public class Main {

    private static void createAndShowGUI(){
        Display display = new Display();
    }
    public static void main(String[] args) {
        CreateConnection connection = new CreateConnection();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}