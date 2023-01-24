package UI;

import Backend.Validate;
import Data.SignupData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignupPage extends JFrame{
    Validate validate = new Validate();
    private JPanel LoginPage;
    private JPanel Content;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField UsernameField;
    private JButton registerButton;
    private JLabel invalidUsername;
    private JLabel invalidEmail;
    private JLabel invalidPassword;
    private JLabel passwordNotMatch;
    private JButton loginButton;
    private JButton studentButton;
    private JButton teacherButton;
    private SignupData data;
    private String role;

    private static void addPlaceholder(JTextField textField, String message){
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(message)) {
                    textField.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(message);
                }
            }
        });
    }

    private boolean validateAll(){
        String username = UsernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String role = this.role;
        if(validate.validateEmail(email) & validate.validateUsername(username) & validate.validatePassword(password) & role != null){
            return true;
        }
        if(validate.validateEmail(email)){
            invalidEmail.setVisible(true);
        }
        if(validate.validatePassword(password)){
            invalidPassword.setVisible(true);
        }
        if(validate.validateUsername(username)){
            invalidUsername.setVisible(true);
        }
        return false;
    }
    private void registerHandler(){
        registerButton.addActionListener(e->{

        });
    }
    private void returnHandler(){
        loginButton.addActionListener(e->{
            new LoginPage();
            setVisible(false);
        });
    }
    private void roleChanger(){
        studentButton.addActionListener(e->{
            this.role = "Student";
            teacherButton.setBackground(Color.white);
            studentButton.setBackground(Color.CYAN);
        });
        teacherButton.addActionListener(e->{
            this.role = "Teacher";
            teacherButton.setBackground(Color.CYAN);
            studentButton.setBackground(Color.white);
        });
    }
    public SignupPage(){
        setContentPane(LoginPage);
        setSize(1280,832);
        addPlaceholder(UsernameField,"& Enter a username");
        addPlaceholder(emailField,"@ Enter your email");
        addPlaceholder(passwordField,"# Enter your password");
        roleChanger();
        registerHandler();
        returnHandler();
//        setUndecorated(true);
        setVisible(true);
    }
}
