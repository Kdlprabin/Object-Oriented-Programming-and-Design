package UI;


import Backend.Users.Admin;
import Backend.Users.Student;
import Backend.Users.Teacher;
import Data.FetchData;
import UI.Helpers.Effects;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
                    setVisible(false);
                    switch (loginInfo.get("role").toLowerCase()) {
                        case "student" -> {
                            Student student = new Student(username);
                            new Homepage(student);
                        }
                        case "teacher" -> {
                            Teacher teacher = new Teacher(username);
                            new Homepage(teacher);
                        }
                        case "admin" -> {
                            Admin admin = new Admin(username);
                            new Homepage(admin);
                        }
                        default -> System.out.println(loginInfo.get("role"));
                    }
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
        Effects effects = new Effects();
        setContentPane(LoginPage);
        setSize(1280,832);
        effects.addPlaceholder(emailField,"& Enter your username");
        effects.addPlaceholder(passwordField,"# Enter your password");
        loginHandler();
        signupHandler();
        setVisible(true);
    }
}
