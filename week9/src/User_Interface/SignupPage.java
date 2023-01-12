package User_Interface;

import javax.swing.*;

public class SignupPage extends JFrame{


    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton createAccountButton;
    private JButton backButton;
    private JPanel SignupPage;

    public SignupPage(){
        setContentPane(SignupPage);
        setTitle("Course Management System");
        setSize(450,300);
        backButton.addActionListener(e ->{
            new LoginPage();
            setVisible(false);
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}
