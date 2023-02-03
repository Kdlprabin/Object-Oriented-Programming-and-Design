package UI;

import Backend.Courses;
import Backend.Users.Admin;
import Backend.Users.Student;
import Backend.Users.Teacher;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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
    private JLabel studentCountValue;
    private JLabel teachersCountValue;
    private JLabel coursesCountValue;
    private JLabel modulesCountValue;

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

    public void getData(Admin admin){
        HashMap<String,Integer> counts= admin.getCounts();
        studentCountValue.setText(counts.get("student").toString());
        teachersCountValue.setText(counts.get("teacher").toString());
        coursesCountValue.setText(counts.get("course").toString());
        modulesCountValue.setText(counts.get("module").toString());
    }
    public Homepage(Admin admin) {
        setContentPane(Homepage);
        setSize(1280,832);
        JButton[] buttons = {dashboardButton, notificationsButton, studentsButton, studentsReportButton, lecturersButton, coursesButton};
        dashboardButton.setBackground(Color.green);
        dashboardButton.setForeground(Color.WHITE);
        getData(admin);
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
