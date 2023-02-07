package Data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//create all the required tables for the system
public class CreateTables {

    public CreateTables(Connection connection) {
        // creating tables
        createUserLoginTable(connection);
        createStudentEnrollmentTable(connection);
        createCourseInfoTable(connection);
        createTeacherInfoTable(connection);
        createModuleInfoTable(connection);
        createStudentInfoTable(connection);
        createEnrollmentTable(connection);
        createOptionalEnrollmentTable(connection);
    }

    private void createUserLoginTable(Connection connection) {
        try {
            Statement createTableUsersLogin = connection.createStatement();
            createTableUsersLogin.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS USERS_LOGIN_DATA(ID int AUTO_INCREMENT PRIMARY KEY,ROLE VARCHAR(10),USERNAME VARCHAR(20),EMAIL VARCHAR(30),PASSWORD VARCHAR(15));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createCourseInfoTable(Connection connection) {
        try {
            Statement createTableCoursesInfo = connection.createStatement();
            createTableCoursesInfo.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS COURSES_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,COURSE_NAME VARCHAR(20),COURSE_DURATION INT, ADDED_BY VARCHAR(20));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTeacherInfoTable(Connection connection) {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS TEACHER_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,TEACHER_NAME VARCHAR(50),COURSE_NAME VARCHAR(30),MODULE_NAME VARCHAR(50));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createModuleInfoTable(Connection connection) {
        try {
            Statement createTableModuleInfo = connection.createStatement();
            createTableModuleInfo.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS MODULES_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,MODULE_NAME VARCHAR(50),COURSE_NAME VARCHAR(30),TEACHER_NAME VARCHAR(30),MODULE_TYPE VARCHAR(50),MODULE_YEAR VARCHAR(10));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createStudentInfoTable(Connection connection) {
        try {
            Statement createTableStudentInfo = connection.createStatement();
            createTableStudentInfo.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS STUDENT_INFO(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createEnrollmentTable(Connection connection) {
        try {
            Statement createTableEnrollment = connection.createStatement();
            createTableEnrollment.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30),MODULE_NAME VARCHAR(50),MARKS_OBTAINED INT);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createStudentEnrollmentTable(Connection connection) {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS STUDENT_ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30),MODULE_NAME VARCHAR(50),MODULE_TYPE VARCHAR(30), STATUS VARCHAR(30), MARKS_OBTAINED VARCHAR(100));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createOptionalEnrollmentTable(Connection connection) {
        try {
            Statement createTableOptionalEnrollment = connection.createStatement();
            createTableOptionalEnrollment.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS OPTIONAL_ENROLLMENT(ID INT AUTO_INCREMENT PRIMARY KEY,STUDENT_NAME VARCHAR(30),COURSE_NAME VARCHAR(30),OPTIONAL_MODULES VARCHAR(50),MARKS_OBTAINED INT);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
