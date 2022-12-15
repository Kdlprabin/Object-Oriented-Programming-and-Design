package course_management_system;

import course_management_system.screens.LoginWindow;

public class Main {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow(1200, 800, true);
        loginWindow.createFrame();
        loginWindow.giveTitle("Course Management System");
        loginWindow.setText("Please enter your login details or create a account.");
    }
}