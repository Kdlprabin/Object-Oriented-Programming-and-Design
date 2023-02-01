package UI;


import Backend.CustomDatatype.UserData;
import Backend.Users.Admin;
import Backend.Users.Student;
import Backend.Users.Teacher;
import Data.FetchData;
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
                    switch (loginInfo.get("role").toLowerCase()){
                        case "student":
                            Student student = new Student(username);
                            new Homepage(student);
                            break;
                        case "teacher":
                            Teacher teacher = new Teacher(username);
                            new Homepage(teacher);
                            break;
                        case "admin":
                            Admin admin = new Admin(username);
                            new Homepage(admin);
                            break;
                        default:
                            System.out.println(loginInfo.get("role"));
                    }
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
