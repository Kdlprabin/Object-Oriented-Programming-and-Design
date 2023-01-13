import User_Interface.Dashboard;

public class Main {
    private static void createAndShowGUI(){
        Dashboard dashboard = new Dashboard();
    }
    public static void main(String[] args)
    {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            createAndShowGUI();
        }
    });
    }
}