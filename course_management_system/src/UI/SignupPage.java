package UI;

import Backend.Exceptions.UserExistsException;
import Backend.Validate;
import Data.SendData;
import Backend.CustomDatatype.SignupData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

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
    private JLabel resultStat;
    private String username;
    private String password;
    private String email;
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
        if(!validate.validateEmail(email)){
            invalidEmail.setVisible(true);
        }else{
            invalidEmail.setVisible(false);
        }
        if(!validate.validatePassword(password)){
            invalidPassword.setVisible(true);
        }else{
            invalidPassword.setVisible(false);
        }
        if(!validate.validateUsername(username)){
            invalidUsername.setVisible(true);
        }else{
            invalidUsername.setVisible(false);
        }
        if(validate.validateEmail(email) & validate.validateUsername(username) & validate.validatePassword(password) & role != null){
            return true;
        }
        return false;
    }
    private void registerHandler(){
        registerButton.addActionListener(e->{
            this.username = UsernameField.getText();
            this.email = emailField.getText();
            this.password = passwordField.getText();
            if(validateAll()){
                SendData sendData = new SendData();
                SignupData s = new SignupData(username,email,role,password);
                try {
                    sendData.signupData(s);
                    resultStat.setText("Account creation successful");
                    resultStat.setForeground(Color.green);
                    resultStat.setVisible(true);
                    setVisible(false);
                    new LoginPage();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (UserExistsException exp){
                    resultStat.setVisible(true);
                }
            }
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
        resultStat.setVisible(false);
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
