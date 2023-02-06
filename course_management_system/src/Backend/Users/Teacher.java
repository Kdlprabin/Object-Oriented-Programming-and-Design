package Backend.Users;

import Backend.Exceptions.CourseNotFoundException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class Teacher extends User{
    public Teacher(String username) {
        this.username = username;
        setEmail();

    }

    public void addMarks(String studentName,String moduleName,String marks){
        try {
            Statement addMarksSt = connection.createStatement();
            addMarksSt.executeUpdate("UPDATE ENROLLMENT SET MARKS_OBTAINED="+marks+" WHERE STUDENT_NAME='"+studentName+"' AND MODULE_NAME='"+moduleName+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editMarks(String id,String name,String module,String marks){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE ENROLLMENT SET STUDENT_NAME='"+name+"',MODULE_NAME='"+module+"',MARKS_OBTAINED='"+marks+"' WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteMarks(String id){
        try {
            Statement addMarksSt = connection.createStatement();
            addMarksSt.executeUpdate("UPDATE ENROLLMENT SET MARKS_OBTAINED=0 WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addModule(String courseName,String moduleName,String moduleType){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO MODULES_INFO(MODULE_NAME,COURSE_NAME,TEACHER_NAME,MODULE_TYPE) VALUES('"+moduleName+"','"+courseName+"','"+this.username+"',"+moduleType+");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editModule(String id,String moduleName,String courseName,String moduleType){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE TEACHER_INFO SET MODULE_NAME='"+moduleName+"',COURSE_NAME='"+courseName+"',TEACHER_NAME='"+this.username+"',MODULE_TYPE="+moduleType+" WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteModule(String id){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM MODULE_INFO WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchStudentReportTableData(JTable table) {
        String query = "SELECT * FROM STUDENT_ENROLLMENT WHERE STATUS='ENROLLED';";
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
                String marks = String.valueOf(res.getString("MARKS_OBTAINED"));
                String[] tbData = {id, name, course, module, marks};
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
    public String getCourseName() {
        String courseName = null;
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * from MODULES_INFO WHERE TEACHER_NAME='"+username+"';");
            while (res.next()) {
                courseName=res.getString("COURSE_NAME");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException E){
            throw new CourseNotFoundException();
        }
        return courseName;
    }
    public ArrayList<String> getModuleList(){
        ArrayList<String> data= new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM MODULES_INFO WHERE TEACHER_NAME='"+username+"';");
            while (res.next()){
                data.add(res.getString("MODULE_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public void fetchModuleTableData(JTable table){
        String query = "SELECT ID,COURSE_NAME,MODULE_NAME,MODULE_TYPE FROM MODULES_INFO WHERE TEACHER_NAME='"+this.username+"';";
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
                String[] tbData = {id, course, module, moduleType};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
