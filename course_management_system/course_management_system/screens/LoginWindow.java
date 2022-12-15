package course_management_system.screens;

import javax.swing.*;

import course_management_system.components.InputField;

import java.awt.*;


public class LoginWindow {
    private int width, height;
    private boolean visibility;
    private String title;

    // creates an object of JFrame class
    JFrame frame = new JFrame();

    // logo
    ImageIcon image = new ImageIcon("C:/Users/Dell/OneDrive/Documents/Assignments/year two/sem 3/Object Oriented Program and Designing/course_management_system/course_management_system/images/course_management_logo.jpg");

    //Header text in window
    JLabel label = new JLabel("");

    //input field 
    InputField inputUsername = new InputField();
    InputField inputPassword = new InputField();
    
    // constructor
    public LoginWindow(int width, int height, boolean visibility) {
        this.width = width;
        this.height = height;
        this.visibility = visibility;
        frame.setResizable(false);
    }

    // creating a window screen
    public void createFrame() {
        frame.setSize(width, height);
        frame.setVisible(visibility);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(0x123456));

        frame.add(label);
        frame.add(inputUsername.makeInputField(450,30));
        frame.add(inputPassword.makeInputField(450,100));
        frame.setLayout(null);
    }

    // getter methods
    public String getTitle() {
        return title;
    }

    // setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        label.setText(text);
        label.setForeground(Color.WHITE);
    }

    // setting up a title on the frame
    public void giveTitle(String title) {
        frame.setTitle(title);
    }

}
