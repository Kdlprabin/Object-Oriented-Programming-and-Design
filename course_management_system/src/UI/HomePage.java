package UI;

import Backend.Courses;
import Backend.Users.Student;
import Backend.Users.Teacher;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame{

    private JPanel HomePage;
    private JButton dashboardButton;
    private JButton settingsButton;
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
    private JList list1;
    private JPanel NotificationsPanel;
    private JLabel CourseNum;
    private JLabel TeacherNum;
    private JLabel StudentsNum;
    private JButton DELETENOWBUTTON;
    private JButton ADDMODULENOWBUTTON;
    private JTextField textField3;
    private JPanel singleData;
    private JPanel doubleData;
    private JList list3;
    private JTextField textField4;

    private void initialWorks(String username){
        welcomeMessage.setText("Welcome "+username);
        //add course function
        ADDButton.addActionListener(e->{
            courseList.setVisible(false);
            addCoursePanel.setVisible(true);
            SUBMITButton.setVisible(true);
            UPDATENOWButton.setVisible(false);
            DELETENOWBUTTON.setVisible(false);
            ADDMODULENOWBUTTON.setVisible(false);
            doubleData.setVisible(false);
        });

        //update button
        UPDATEButton.addActionListener(e->{
            courseList.setVisible(false);
            addCoursePanel.setVisible(true);
            SUBMITButton.setVisible(false);
            UPDATENOWButton.setVisible(true);
            DELETENOWBUTTON.setVisible(false);
            ADDMODULENOWBUTTON.setVisible(false);
            singleData.setVisible(false);
            doubleData.setVisible(false);
        });
        DELETEButton.addActionListener(e->{
            courseList.setVisible(false);
            addCoursePanel.setVisible(false);
            ADDMODULENOWBUTTON.setVisible(false);
            DELETENOWBUTTON.setVisible(true);
            SUBMITButton.setVisible(false);
            UPDATENOWButton.setVisible(true);
            singleData.setVisible(true);
            doubleData.setVisible(false);
        });
        ADDMODULEButton.addActionListener(e->{
            courseList.setVisible(false);
            addCoursePanel.setVisible(false);
            ADDMODULENOWBUTTON.setVisible(true);
            UPDATENOWButton.setVisible(false);
            SUBMITButton.setVisible(false);
            DELETENOWBUTTON.setVisible(false);
            singleData.setVisible(true);
            doubleData.setVisible(true);
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

        //dashboard elements counts
        getCounts();
    }

    private void getCourseList() {
        Courses courses = new Courses();
        courseList.setListData(courses.getCourseList().toArray());

    }
    private void getCounts(){
        //COURSES count
        Courses courses = new Courses();
        String oldCourseText = CourseNum.getText();
        CourseNum.setText(oldCourseText+courses.getCourseCount());
        //TEACHERS count
        Teacher teacher = new Teacher();
        String oldTeacherText = TeacherNum.getText();
        TeacherNum.setText(oldTeacherText+teacher.getTeachersCount());
        //STUDENTS count
        Student student = new Student();
        String oldStudentText = StudentsNum.getText();
        StudentsNum.setText(oldStudentText+student.getStudentsCount());
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
            settingsButton.setForeground(Color.red);
            coursesButton.setForeground(Color.blue);
            dashboardButton.setForeground(Color.green);
            button.setForeground(Color.white);
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
        setResizable(false);
    }
}
