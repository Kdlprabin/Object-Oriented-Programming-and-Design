package User_Interface;

import javax.swing.*;

public class Welcome extends JFrame{
    private JPanel Welcome;
    private JButton loginPageButton;

    public Welcome(){
        setContentPane(Welcome);
        setTitle("Course Management System");
        setSize(450,300);
        loginPageButton.addActionListener(e ->{
            new LoginPage();
            setVisible(false);
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}
