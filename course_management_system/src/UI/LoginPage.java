package UI;

import Backend.Validate;
import Data.Database;
import Data.FetchData;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;

public class LoginPage extends JFrame{
    FetchData fetchData = new FetchData();
    private JPanel LoginPage;
    private JPanel Content;
    private JTextField emailField;
    private JButton signupButton;
    private JTextField passwordField;
    private JLabel emailInvalid;
    private JLabel passwordInvalid;
    private JButton loginButton;


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
    private void loginHandler(){
        loginButton.addActionListener(e->{
                String username = emailField.getText();
                String password = passwordField.getText();
                HashMap<String, String> loginInfo = fetchData.loginData(username);
                if(loginInfo.get("password") == null){
                    passwordInvalid.setVisible(true);
                    return;
                }
                if (loginInfo.get("password").equals(password)) {
                    new HomePage();
                    setVisible(false);
                }else{
                    passwordInvalid.setVisible(true);
                }
                if (username.contains(" ")) {
                    emailInvalid.setVisible(true);
                }
        });
    }
    public void signupHandler(){
        signupButton.addActionListener(e->{
            new SignupPage();
            setVisible(false);
        });
    }
    public LoginPage(){

        setContentPane(LoginPage);
        setSize(1280,832);
        addPlaceholder(emailField,"@ Enter your email");
        addPlaceholder(passwordField,"# Enter your password");
        loginHandler();
        signupHandler();
        setVisible(true);
    }
}
