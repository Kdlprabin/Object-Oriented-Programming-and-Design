import UI.LoginPage;

public class Main {

    static void createAndShowGUI(){
            new LoginPage();
    }
    public static void main(String[] args) {
                javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}