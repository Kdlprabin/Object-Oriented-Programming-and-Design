package UI;

import Backend.Validate;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignupPage extends JFrame{
    Validate validate = new Validate();
    private JPanel LoginPage;
    private JPanel Content;
    private JTextField emailField;
    private JButton backButton;
    private JTextField passwordField;
    private JTextField UsernameField;
    private JTextField confirmPasswordField;
    private JButton registerButton;
    private JLabel invalidUsername;
    private JLabel invalidEmail;
    private JLabel invalidPassword;
    private JLabel passwordNotMatch;

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
    private boolean checkUsername(){
        String Username = UsernameField.getText();
        if(Username.length() > 20){
            return true;
        }
        invalidUsername.setVisible(true);
        return false;
    }
    private boolean checkPassword(){
        String password = passwordField.getText();
        if(validate.validatePassword(password)){
            return true;
        };
        invalidPassword.setVisible(true);
        return false;
    }
    private boolean checkConfirmPassword(){
        if(passwordField.getText() == confirmPasswordField.getText()){
            return true;
        }
        passwordNotMatch.setVisible(true);
        return false;
    }
    private boolean checkEmail(){
        String email = emailField.getText();
        if(validate.validateEmail(email)){
            return true;
        }
        invalidEmail.setVisible(true);
        return false;
    }

    private void registerHandler(){
        registerButton.addActionListener(e->{
            if(checkUsername() & checkEmail() & checkPassword() & checkConfirmPassword()){
                new HomePage();
                setVisible(false);
            };
        });
    }
    private void returnHandler(){
        backButton.addActionListener(e->{
            new LoginPage();
            setVisible(false);
        });
    }
    public SignupPage(){
        setContentPane(LoginPage);
        setSize(1280,832);
        addPlaceholder(UsernameField,"& Enter a username");
        addPlaceholder(emailField,"@ Enter your email");
        addPlaceholder(passwordField,"# Enter your password");
        addPlaceholder(confirmPasswordField,"# Re-enter your password");
        registerHandler();
        returnHandler();
//        setUndecorated(true);
        setVisible(true);
    }
}
