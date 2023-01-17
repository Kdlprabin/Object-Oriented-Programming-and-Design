import javax.swing.*;

public class HomePage extends JFrame{
    private JPanel HomePage;
    private JPanel TitleBar;
    private JButton loginButton;
    private JButton registerButton;
    private JButton coursesButton;
    private JButton scholorButton;
    private JButton alumniButton;
    private JButton contactUsButton;
    private JButton aboutUsButton;
    private JPanel Buttons;
    private JTextPane inThisModuleYouTextPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton submitButton;
    private JPanel CourseCard;
    private JPanel ContactCard;

    public HomePage(){
        setContentPane(HomePage);
        setSize(600,400);
        coursesButton.addActionListener(e->{
            CourseCard.setVisible(true);
            ContactCard.setVisible(false);
        });
        contactUsButton.addActionListener(e->{
            CourseCard.setVisible(false);
            ContactCard.setVisible(true);
        });
        setVisible(true);
        setResizable(false);
    }
}
