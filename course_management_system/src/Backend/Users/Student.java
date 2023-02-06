package Backend.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Student extends User{
    public Student(String username) {
        this.username = username;
        setEmail();
    }

    public void enrollModules(String moduleName){
        try {
            Statement enrollModulesSt = connection.createStatement();
            enrollModulesSt.executeUpdate("UPDATE STUDENT_ENROLLMENT SET STATUS='ENROLLED' WHERE STUDENT_NAME='"+username+"' AND MODULE_NAME='"+moduleName+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCourseName(){
        String courseName = null;
        try {
            Statement st = connection.createStatement();
            ResultSet res =st.executeQuery("SELECT * FROM STUDENT_ENROLLMENT WHERE STUDENT_NAME='"+username+"';");
            while(res.next()){
                if (res.getString("COURSE_NAME") != null) {
                    courseName = res.getString("COURSE_NAME");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseName;
    }
    public void fetchTeacherData(JTable table,String courseName) {
        String query = "SELECT * FROM TEACHER_INFO WHERE COURSE_NAME='"+courseName+"'";
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
                String module = String.valueOf(res.getString("MODULE_NAME"));
                String course = String.valueOf(res.getString("COURSE_NAME"));
                String name = String.valueOf(res.getString("TEACHER_NAME"));
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
                String name = String.valueOf(res.getString("COURSE_NAME"));
                String cost = String.valueOf(res.getString("COURSE_COST"));
                String addedBy = String.valueOf(res.getString("ADDED_BY"));
                String[] tbData = {id, name, cost, addedBy};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchStudentReportTableData(JTable table) {
        String query = "SELECT ID,MODULE_NAME,MARKS_OBTAINED FROM STUDENT_ENROLLMENT WHERE STUDENT_NAME='"+username+"';";
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
                String module = String.valueOf(res.getString("MODULE_NAME"));
                String marks = String.valueOf(res.getString("MARKS_OBTAINED"));
                String[] tbData = {id, module, marks};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchEnrollmentTableData(JTable table){
        String query = "SELECT ID,STUDENT_NAME,COURSE_NAME,MODULE_NAME,MODULE_TYPE,STATUS FROM STUDENT_ENROLLMENT WHERE COURSE_NAME='"+getCourseName()+"' AND STUDENT_NAME='"+username+"';";
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
                String name = String.valueOf(res.getString("STUDENT_NAME"));
                String course = String.valueOf(res.getString("COURSE_NAME"));
                String module = String.valueOf(res.getString("MODULE_NAME"));
                String type = String.valueOf(res.getString("MODULE_TYPE"));
                String status = String.valueOf(res.getString("STATUS"));
                String[] tbData = {id, name,course, module, type,status};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
