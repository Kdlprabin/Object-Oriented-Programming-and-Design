package Backend.Users;

import Data.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private final String username;

    private String email;
    Database database = new Data.Database();
    Connection connection = database.connectToDatabase();
    private String[] optionalModules;
    public String getEmail() {
        return email;
    }

    public void setEmail() {
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM USERS_LOGIN_DATA WHERE username='"+username+"';");
            while (res.next()){
                this.email = res.getString("email");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student( String username){
        this.username = username;
        setEmail();
    }
    public String getUsername() {
        return username;
    }
    private void chooseCourse(String courseName)throws SQLException {
        Statement chooseCourseSt = connection.createStatement();
        chooseCourseSt.executeUpdate("UPDATE STUDENT_INFO SET courseName='"+courseName+"' WHERE studentName='"+username+"';");
    }
    private void enrollModules(ArrayList<String> moduleName)throws  SQLException{
        Statement enrollModulesSt = connection.createStatement();
        for(String m:moduleName){
            enrollModulesSt.executeUpdate("INSERT INTO ENROLLMENT(studentName,moduleName)VALUES('" + username + "','" + m + "');");
        }
    }
    private ArrayList<String> getModuleInstructors(String moduleName)throws SQLException{
        ArrayList<String> instructors = new ArrayList<>();
        Statement getModuleInstructorsSt = connection.createStatement();
        ResultSet res = getModuleInstructorsSt.executeQuery("SELECT * FROM MODULES_INFO WHERE moduleName='"+moduleName+"';");
        while(res.next()){
            instructors.add(res.getString("teacherName"));
        }
        return instructors;
    }
    private void chooseOptionalModules(){}

    public String getCourseName(){
        try {
            Statement st = connection.createStatement();
            ResultSet res =st.executeQuery("SELECT * FROM ENROLLMENT WHERE studentName='"+username+"';");
            while (res.next()){
                return res.getString("courseName");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public HashMap<String, Integer> getCounts() {
        String studentQuery = "SELECT COUNT(*) FROM STUDENT_INFO;";
        String teacherQuery = "SELECT COUNT(*) FROM TEACHER_INFO;";
        String courseQuery = "SELECT COUNT(*) FROM COURSES_INFO;";
        String moduleQuery = "SELECT COUNT(*) FROM MODULES_INFO;";
        HashMap<String, Integer> data = new HashMap<>();
        try {
            Statement studentSt = connection.createStatement();
            Statement teacherSt = connection.createStatement();
            Statement courseSt = connection.createStatement();
            Statement moduleSt = connection.createStatement();

            ResultSet student = studentSt.executeQuery(studentQuery);
            ResultSet teacher = teacherSt.executeQuery(teacherQuery);
            ResultSet course = courseSt.executeQuery(courseQuery);
            ResultSet module = moduleSt.executeQuery(moduleQuery);

            while (student.next()) {
                data.put("student", student.getInt(1));
            }
            while (teacher.next()) {
                data.put("teacher", teacher.getInt(1));
            }
            while (course.next()) {
                data.put("course", course.getInt(1));
            }
            while (module.next()) {
                data.put("module", module.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public void fetchTeacherData(JTable table,String courseName) {
        String query = "SELECT * FROM TEACHER_INFO WHERE Course_Name=";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(query+courseName);
            ResultSetMetaData rsmd = res.getMetaData();
            int colCount = rsmd.getColumnCount();
            String[] colName = new String[colCount];
            for (int i = 0; i < colCount; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colName);
            }
            while (res.next()) {
                String id = String.valueOf(res.getInt("ID"));
                String module = String.valueOf(res.getString("Module_Name"));
                String course = String.valueOf(res.getString("Course_Name"));
                String name = String.valueOf(res.getString("Teacher_Name"));
                String[] tbData = {id, name, course, module};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void fetchCourseData(JTable table) {
        String query = "SELECT * FROM COURSES_INFO";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData();
            int colCount = rsmd.getColumnCount();
            String[] colName = new String[colCount];
            for (int i = 0; i < colCount; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colName);
            }
            while (res.next()) {
                String id = String.valueOf(res.getInt("ID"));
                String name = String.valueOf(res.getString("courseName"));
                String cost = String.valueOf(res.getString("courseCost"));
                String addedBy = String.valueOf(res.getString("addedBy"));
                String[] tbData = {id, name, cost, addedBy};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchStudentReportTableData(JTable table) {
        String query = "SELECT * FROM ENROLLMENT WHERE studentName='"+username+"';";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData();
            int colCount = rsmd.getColumnCount();
            String[] colName = new String[colCount];
            for (int i = 0; i < colCount; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colName);
            }
            while (res.next()) {
                String id = String.valueOf(res.getInt("id"));
                String name = String.valueOf(res.getString("studentName"));
                String course = String.valueOf(res.getString("courseName"));
                String module = String.valueOf(res.getString("moduleName"));
                String marks = String.valueOf(res.getString("marksObtained"));
                String[] tbData = {id, name, course, module, marks};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchEnrollmentTableData(JTable table){
        String query = "SELECT * FROM STUDENT_ENROLLMENT WHERE Course_Name='"+getCourseName()+"' AND Student_Name='"+username+"';";
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData();
            int colCount = rsmd.getColumnCount();
            String[] colName = new String[colCount];
            for (int i = 0; i < colCount; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colName);
            }
            while (res.next()) {
                String id = String.valueOf(res.getInt("ID"));
                String name = String.valueOf(res.getString("Student_Name"));
                String module = String.valueOf(res.getString("Module_Name"));
                String type = String.valueOf(res.getString("Module_Type"));
                String status = String.valueOf(res.getString("Statue"));
                String[] tbData = {id, name, module, type,status};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
