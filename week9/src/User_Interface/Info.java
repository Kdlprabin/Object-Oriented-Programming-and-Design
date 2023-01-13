package User_Interface;

import javax.swing.*;

public class Info extends JFrame {
    private JTextPane thisPageContainsTheTextPane;
    private JButton backButton;
    private JTextArea nameTextArea;
    private JButton logOutButton;
    private JPanel InfoPage;
    private JButton coursesButton;


    public Info(String name) {
        setContentPane(InfoPage);
        setTitle("Course Management System");
        setSize(450, 300);
        nameTextArea.append(name);
        logOutButton.addActionListener(e->{
            new LoginPage();
            setVisible(false);
        });
        backButton.addActionListener(e->{
            new Welcome(name);
            setVisible(false);
        });
        coursesButton.addActionListener(e->{
            new Courses();
            setVisible(false);
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}