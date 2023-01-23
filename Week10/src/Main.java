import Database.CreateConnection;
import Database.CreateDatabase;
import Database.SupplyData;
import Frontend.Display;

public class Main {

    //to create and show GUI
    private static void createAndShowGUI(){
        try {
            Display display = new Display();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new CreateDatabase();
        new SupplyData();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}