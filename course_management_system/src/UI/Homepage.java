package UI;

import Backend.Users.Admin;
import Backend.Users.Student;
import Backend.Users.Teacher;

import javax.swing.*;
import java.awt.*;

public class Homepage extends JFrame{
    private JPanel Sidebar;
    private JPanel Homepage;
    private JButton dashboardButton;
    private JButton notificationsButton;
    private JButton studentsButton;
    private JButton studentsReportButton;
    private JButton lecturersButton;
    private JButton coursesButton;
    private JButton button1;

    void clickHandler(JButton button){
        button.addActionListener(e->{
            JButton[] buttons = {dashboardButton, notificationsButton, studentsButton, studentsReportButton, lecturersButton, coursesButton};
            for (JButton b : buttons) {
                b.setBackground(Color.white);
                b.setForeground(Color.BLACK);
            }
            button.setBackground(Color.green);
            button.setForeground(Color.white);
        });
    }

    public Homepage(Admin admin) {
        setContentPane(Homepage);
        setSize(1280,832);
        JButton[] buttons = {dashboardButton, notificationsButton, studentsButton, studentsReportButton, lecturersButton, coursesButton};
        dashboardButton.setBackground(Color.green);
        dashboardButton.setForeground(Color.WHITE);
        for(JButton b: buttons){
            clickHandler(b);
        }
        setVisible(true);
    }

    public Homepage(Teacher teacher) {
        setContentPane(Homepage);
        setSize(1280,832);
        setVisible(true);
    }
    public Homepage(Student student) {
        setContentPane(Homepage);
        setSize(1280,832);
        setVisible(true);
    }
}
