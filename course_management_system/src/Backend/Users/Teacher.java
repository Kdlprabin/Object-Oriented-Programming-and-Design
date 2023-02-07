package Backend.Users;

import Backend.Exceptions.CourseNotFoundException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class Teacher extends User {
    public Teacher(String username) {
        this.username = username;
        setEmail();

    }

    public void addMarks(String studentName, String moduleName, String marks) {
        try {
            Statement addMarksSt = connection.createStatement();
            addMarksSt.executeUpdate("UPDATE STUDENT_ENROLLMENT SET MARKS_OBTAINED=" + marks + " WHERE STUDENT_NAME='"
                    + studentName + "' AND MODULE_NAME='" + moduleName + "';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editMarks(String id, String name, String module, String marks) {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE STUDENT_ENROLLMENT SET STUDENT_NAME='" + name + "',MODULE_NAME='" + module
                    + "',MARKS_OBTAINED='" + marks + "' WHERE ID=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteMarks(String id) {
        try {
            Statement addMarksSt = connection.createStatement();
            addMarksSt.executeUpdate("UPDATE STUDENT_ENROLLMENT SET MARKS_OBTAINED=0 WHERE ID=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchStudentResultTableData(JTable table) {
        String query = "SELECT ID,STUDENT_NAME,MODULE_NAME,MARKS_OBTAINED FROM STUDENT_ENROLLMENT WHERE STATUS='ENROLLED';";
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
                String module = String.valueOf(res.getString("MODULE_NAME"));
                String marks = String.valueOf(res.getString("MARKS_OBTAINED"));
                String[] tbData = { id, name, module, marks };
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
                String cost = String.valueOf(res.getString("COURSE_DURATION"));
                String addedBy = String.valueOf(res.getString("ADDED_BY"));
                String[] tbData = { id, name, cost, addedBy };
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCourseName() {
        String courseName = null;
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * from MODULES_INFO WHERE TEACHER_NAME='" + username + "';");
            while (res.next()) {
                courseName = res.getString("COURSE_NAME");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException E) {
            throw new CourseNotFoundException();
        }
        return courseName;
    }

    public ArrayList<String> getModuleList() {
        ArrayList<String> data = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM MODULES_INFO WHERE TEACHER_NAME='" + username + "';");
            while (res.next()) {
                data.add(res.getString("MODULE_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void fetchModuleTableData(JTable table) {
        String query = "SELECT ID,COURSE_NAME,MODULE_NAME,MODULE_TYPE,MODULE_YEAR FROM MODULES_INFO WHERE TEACHER_NAME='"
                + this.username + "';";
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
                String moduleType = String.valueOf(res.getString("MODULE_TYPE"));
                String moduleDuration = String.valueOf(res.getString("MODULE_YEAR"));
                String[] tbData = { id, course, module, moduleType,moduleDuration };
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
