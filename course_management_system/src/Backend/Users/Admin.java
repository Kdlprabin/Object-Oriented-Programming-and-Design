package Backend.Users;

import Backend.Exceptions.CourseNotFoundException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;


public class Admin extends User {
    public Admin(String username) {
        this.username = username;
        setEmail();
    }

    public void addStudent(String studentName,String courseName){
        ArrayList<String> moduleNames = new ArrayList<>();
        ArrayList<String> moduleTypes = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            Statement st3 = connection.createStatement();
            ResultSet res = st3.executeQuery("SELECT * FROM MODULES_INFO WHERE COURSE_NAME='"+courseName+"'");
            while(res.next()){
                moduleNames.add(res.getString("Module_Name"));
                moduleTypes.add(res.getString("Module_Type"));
            }
            st.executeUpdate("INSERT INTO STUDENT_INFO(STUDENT_NAME,COURSE_NAME) VALUES('"+studentName+"','"+courseName+"');");
            for(int i =0;i<moduleTypes.size();i++){
                st.executeUpdate("INSERT INTO STUDENT_ENROLLMENT(STUDENT_NAME,COURSE_NAME,MODULE_NAME,MODULE_TYPE,STATUS) VALUES('"+studentName+"','"+courseName+"','"+moduleNames.get(i)+"','"+moduleTypes.get(i)+"','Not Enrolled');");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editStudent(String id,String studentName,String courseName){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE STUDENT_INFO SET STUDENT_NAME='"+studentName+"',COURSE_NAME='"+courseName+"' WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteStudent(String id){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM STUDENT_INFO WHERE ID='"+id+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addCourse(String courseName, String courseCost)  {
        try {
            Statement addCourseSt = connection.createStatement();
            addCourseSt.executeUpdate("INSERT INTO COURSES_INFO(COURSE_NAME,COURSE_COST,ADDED_BY) VALUES ('" + courseName + "', '" + courseCost  + "','" + username + "');");
            return false;
        } catch (SQLException e) {
            return true;
        }
    }
    public void editCourse(String id,String courseName,String courseCost){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE COURSES_INFO SET COURSE_NAME='"+courseName+"',COURSE_COST='"+courseCost+"' WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCourse(String id) {
        try {
            Statement deleteCourseSt = connection.createStatement();
            deleteCourseSt.executeUpdate("DELETE FROM COURSES_INFO WHERE ID='" + id + "';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTeacher(String name,String module,String course){
        try {
            Statement st1 = connection.createStatement();
            Statement st2 = connection.createStatement();
            st1.executeUpdate("INSERT INTO TEACHER_INFO(TEACHER_NAME,COURSE_NAME,MODULE_NAME) VALUES('"+name+"','"+course+"','"+module+"');");
            st2.executeUpdate("UPDATE MODULES_INFO SET TEACHER_NAME ='"+name+"' WHERE MODULE_NAME='"+module+"' AND COURSE_NAME='"+course+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void editTeacher(String id,String name,String course,String module){
        try {
            Statement st = connection.createStatement();
            Statement st1 =connection.createStatement();
            Statement st2 = connection.createStatement();
            st.executeUpdate("UPDATE TEACHER_INFO SET TEACHER_NAME='"+name+"',COURSE_NAME='"+course+"',MODULE_NAME='"+module+"' WHERE ID="+id);
            st1.executeUpdate("UPDATE MODULES_INFO SET TEACHER_NAME ='"+name+"' WHERE MODULE_NAME='"+module+"' AND COURSE_NAME='"+course+"';");
            st2.executeUpdate("UPDATE MODULES_INFO SET MODULE_NAME ='"+module+"' WHERE TEACHER_NAME='"+name+"' AND COURSE_NAME='"+course+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteTeacher(String id,String teacherName,String moduleName){
        try {
            Statement st = connection.createStatement();
            Statement st1 = connection.createStatement();
            st.executeUpdate("DELETE FROM TEACHER_INFO WHERE id='"+id+"';");
            st1.executeUpdate("UPDATE MODULES_INFO SET TEACHER_NAME ='Not assigned' WHERE TEACHER_NAME='"+teacherName+" AND MODULE_NAME='"+moduleName+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void addModule(String courseName,String moduleName,String moduleType){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO MODULES_INFO(MODULE_NAME,COURSE_NAME,MODULE_TYPE) VALUES('"+moduleName+"','"+courseName+"','"+moduleType+"');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editModule(String id,String moduleName,String courseName,String moduleType){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE MODULES_INFO SET MODULE_NAME='"+moduleName+"',COURSE_NAME='"+courseName+"',MODULE_TYPE='"+moduleType+"' WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteModule(String id,String moduleName){
        try {
            Statement st = connection.createStatement();
            Statement st1=connection.createStatement() ;
            st.executeUpdate("DELETE FROM MODULES_INFO WHERE ID="+id);
            st1.executeUpdate("UPDATE TEACHER_INFO SET MODULE_NAME='Not Available' WHERE MODULE_NAME='"+moduleName+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchTeacherData(JTable table) {
        String query = "SELECT * FROM TEACHER_INFO";
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
                String[] tbData = {id, name, module, course};
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
    public void fetchStudentTableData(JTable table) {
        String query = "SELECT * FROM STUDENT_INFO;";
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
                String[] tbData = {id, name, course};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchModuleTableData(JTable table){
        String query = "SELECT ID,COURSE_NAME,MODULE_NAME,MODULE_TYPE FROM MODULES_INFO";
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
    public ArrayList<String> getCourseList() {
        ArrayList<String> List = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * from COURSES_INFO;");
            while (res.next()) {
                List.add(res.getString("COURSE_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException E){
            throw new CourseNotFoundException();
        }
        return List;
    }
    public ArrayList<String> getModuleList(String courseName){
        ArrayList<String> data= new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM MODULES_INFO WHERE COURSE_nAME='"+courseName+"';");
            while (res.next()){
                data.add(res.getString("MODULE_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    }
