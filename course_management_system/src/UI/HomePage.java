package UI;

import Backend.Courses;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame{

    private JPanel HomePage;
    private JButton dashboardButton;
    private JButton settingsButton;
    private JButton labelButton;
    private JButton coursesButton;
    private JLabel welcomeMessage;
    private JButton ADDButton;
    private JList courseList;
    private JButton backButton;
    private JButton SUBMITButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JList list2;
    private JPanel addCoursePanel;
    private JButton UPDATEButton;
    private JButton ADDMODULEButton;
    private JButton DELETEButton;
    private JButton UPDATENOWButton;
    private JPanel Courses;
    private JPanel Dashboard;
    private JPanel Settings;
    private JPanel boardTitle;

    private void initialWorks(String username){
        welcomeMessage.setText("Welcome "+username);
        //add course function
        ADDButton.addActionListener(e->{
            courseList.setVisible(false);
            addCoursePanel.setVisible(true);
        });

        //update button

        UPDATEButton.addActionListener(e->{
            courseList.setVisible(false);
            addCoursePanel.setVisible(true);
            SUBMITButton.setVisible(false);
            UPDATENOWButton.setVisible(true);
        });
        //back button
        backButton.addActionListener(e->{
            courseList.setVisible(true);
            addCoursePanel.setVisible(false);
        });
        //get the list of courses to display
        getCourseList();

        //select the board to show
        boardSelector(dashboardButton,Dashboard);
        boardSelector(settingsButton,Settings);
        boardSelector(coursesButton,Courses);
    }

    private void getCourseList() {
        Courses courses = new Courses();
        courseList.setListData(courses.getCourseList().toArray());
    }
    private void boardSelector(JButton button,JPanel panel){
        JPanel panels[] = {Settings,Courses,Dashboard};
        JButton buttons[] = {settingsButton,coursesButton,dashboardButton};
        button.addActionListener(e->{
            for(JPanel p:panels){
                p.setVisible(false);
            }
            for(JButton b:buttons){
                b.setBackground(Color.white);
            }
            button.setBackground(Color.green);
            panel.setVisible(true);
        });
    }
    public HomePage(String username){
        setContentPane(HomePage);
        initialWorks(username);
        dashboardButton.addActionListener(e->{
            Settings.setVisible(false);
            Courses.setVisible(false);
            Dashboard.setVisible(true);
        });
        setSize(1280,832);
        setVisible(true);
    }
}
