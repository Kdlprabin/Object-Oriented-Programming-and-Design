public class Main {

    private static void createAndShowGUI(){
        HomePage homePage = new HomePage();
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