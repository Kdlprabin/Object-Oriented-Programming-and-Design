import UI.LoginPage;
import UI.SignupPage;

import java.sql.Driver;
import java.sql.DriverManager;

public class Main {

    static void createAndShowGUI(){
        LoginPage loginPage = new LoginPage();
    }
    public static void main(String[] args) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }
}