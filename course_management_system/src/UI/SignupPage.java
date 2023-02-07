package UI;

import Backend.Exceptions.UserExistsException;
import Backend.Validate;
import Data.SendData;
import Backend.CustomDatatype.SignupData;
import UI.Helpers.Effects;
import UI.Helpers.MyColor;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class SignupPage extends JFrame{
    Validate validate = new Validate();
    private JPanel LoginPage;
    private JTextField emailField,passwordField,UsernameField;
    private JLabel invalidUsername,invalidEmail,invalidPassword;
    private JButton loginButton,studentButton,teacherButton,registerButton;
    private JLabel resultStat;
    private String username,password,email,role;
    private boolean validateAll(){
        invalidEmail.setVisible(!validate.validateEmail(email));
        invalidPassword.setVisible(!validate.validatePassword(password));
        invalidUsername.setVisible(!validate.validateUsername(username));
        return validate.validateEmail(email) && validate.validateUsername(username) && validate.validatePassword(password) && role != null;
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
        MyColor myColor = new MyColor();
        studentButton.addActionListener(e->{
            this.role = "Student";
            teacherButton.setBackground(Color.white);
            studentButton.setBackground(myColor.myGreen);
            studentButton.setForeground(Color.white);
            teacherButton.setForeground(myColor.myBlack);
        });
        teacherButton.addActionListener(e->{
            this.role = "Teacher";
            teacherButton.setBackground(myColor.myGreen);
            studentButton.setBackground(Color.white);
            teacherButton.setForeground(Color.white);
            studentButton.setForeground(myColor.myBlack);
        });
    }
    public SignupPage(){
        Effects effects = new Effects();
        resultStat.setVisible(false);
        setContentPane(LoginPage);
        setSize(1280,832);
        effects.addPlaceholder(UsernameField,"& Enter your name");
        effects.addPlaceholder(emailField,"@ Enter your email");
        effects.addPlaceholder(passwordField,"# Enter your password");
        roleChanger();
        registerHandler();
        returnHandler();
//        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
