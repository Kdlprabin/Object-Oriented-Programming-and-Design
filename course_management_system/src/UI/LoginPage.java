package UI;

import Backend.Validate;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginPage extends JFrame{
    Validate validate = new Validate();
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
    private boolean checkPassword(){
        String password = "Chitwannepal#4";
        if(password.equals(passwordField.getText())){
            return true;
        }
        passwordInvalid.setVisible(true);
        return false;
    }
    private boolean checkEmail(){
        String email = "prabinkandel@gmail.com";
        if(email.equals(emailField.getText())){
            return true;
        }
        emailInvalid.setVisible(true);
        return false;
    }
    private void loginHandler(){
        loginButton.addActionListener(e->{
            if(checkEmail() & checkPassword()){
                new HomePage();
                setVisible(false);
            };
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
//        setUndecorated(true);
        setVisible(true);
    }
}
