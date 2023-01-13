package User_Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Locale;

public class LoginPage extends JFrame{
    private JTextField enterYourUsernameTextField;
    private JPasswordField enterYourPasswordPasswordField;
    private JButton loginButton;
    private JButton signupButton;
    private JPanel LoginPage;
    private JLabel errorPasswordMsg;

    private void signUpFunction(){
        signupButton.addActionListener(e ->{
            new SignupPage();
            setVisible(false);
        });
    }
    private boolean checkUser(String name, String password){
        if(name.equals("Prabin") & password.equals("")){
            return true;
        }

        return false;
    }
    private String getUserName(){
        return enterYourUsernameTextField.getText();
    }
    private void LoginFunction(){
        errorPasswordMsg.setVisible(false);
        char[] password = enterYourPasswordPasswordField.getPassword();
        System.out.println(password);
        loginButton.addActionListener(e->{
            if(checkUser(getUserName(), "")){
                new Welcome(getUserName());
                setVisible(false);
                return;
            }
            errorPasswordMsg.setRequestFocusEnabled(true);
            errorPasswordMsg.setVisible(true);
        });
    }

    public LoginPage(){
        setContentPane(LoginPage);
        setTitle("Course Management System");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signUpFunction();
        LoginFunction();
        setVisible(true);
        setResizable(false);
    }

}
