package Frontend;

import javax.swing.*;

public class Display extends JFrame{
    private JPanel Display;
    private JButton signUpButton;
    private JButton signInButton;
    private JPanel IdData;
    private JPanel LastNameData;
    private JPanel FirstNameData;

    public Display(){
        setContentPane(Display);
        setSize(500,500);
        setVisible(true);
    }
}
