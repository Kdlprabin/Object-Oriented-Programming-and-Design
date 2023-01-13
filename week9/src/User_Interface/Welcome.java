package User_Interface;

import javax.swing.*;

public class Welcome extends JFrame{
    private JPanel Welcome;
    private JButton loginPageButton;
    private JButton viewInfoButton;
    private JLabel welcomeMessage;

    public Welcome(String name){
        setContentPane(Welcome);
        setTitle("Course Management System");
        setSize(450,300);
        if(!name.equals("")){
            welcomeMessage.setText("Welcome " + name);
        }else{
            welcomeMessage.setText("Welcome User");
        }
        viewInfoButton.addActionListener(e->{
            new Info(name);
            setVisible(false);
        });
        loginPageButton.addActionListener(e ->{
            new LoginPage();
            setVisible(false);
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}
