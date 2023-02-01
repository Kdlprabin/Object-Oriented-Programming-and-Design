import Backend.Users.Admin;
import UI.Homepage;
import UI.LoginPage;

public class Main {

    static void createAndShowGUI(){
       Admin admin = new Admin("ADMIN");
        new Homepage(admin);
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