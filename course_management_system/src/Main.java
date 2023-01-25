import UI.LoginPage;

import java.sql.SQLException;

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