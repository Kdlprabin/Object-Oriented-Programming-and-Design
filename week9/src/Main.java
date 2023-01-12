import User_Interface.LoginPage;
import User_Interface.SignupPage;

import javax.swing.*;

public class Main{
    private static void createAndShowGUI() {
        LoginPage loginPage = new LoginPage();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}