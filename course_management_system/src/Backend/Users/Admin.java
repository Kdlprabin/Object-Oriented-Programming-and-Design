package Backend.Users;

import Data.Database;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Admin extends User {

    private String username;
    private String email;

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

    private final Database database = new Database();
    private final Connection connection = database.connectToDatabase();

    public Admin(String username) {
        this.username = username;
        setEmail();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addStudent(String studentName,String courseName){
        ArrayList<String> moduleNames = new ArrayList<>();
        ArrayList<String> moduleTypes = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            Statement st2 = connection.createStatement();
            Statement st3 = connection.createStatement();
            ResultSet res = st3.executeQuery("SELECT * FROM MODULES_INFO WHERE Course_Name='"+courseName+"'");
            while(res.next()){
                moduleNames.add(res.getString("Module_Name"));
                moduleTypes.add(res.getString("Module_Type"));
            }
            st.executeUpdate("INSERT INTO STUDENT_INFO(studentName,courseName) VALUES('"+studentName+"','"+courseName+"');");
            for(int i =0;i<moduleTypes.size();i++){
                st.executeUpdate("INSERT INTO STUDENT_ENROLLMENT(Student_Name,Course_Name,Module_Name,Module_Type,Status) VALUES('"+studentName+"','"+courseName+"','"+moduleNames.get(i)+"','"+moduleTypes.get(i)+"','Not Enrolled');");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editStudent(String id,String studentName,String courseName){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE STUDENT_INFO SET studentName='"+studentName+"',courseName='"+courseName+"' WHERE id="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteStudent(String id){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM STUDENT_INFO WHERE id='"+id+"';");
            System.out.println("deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addCourse(String courseName, String courseCost)  {
        try {
            Statement addCourseSt = connection.createStatement();
            addCourseSt.executeUpdate("INSERT INTO COURSES_INFO(courseName,courseCost,addedBy) VALUES ('" + courseName + "', '" + courseCost  + "','" + username + "');");
            return false;
        } catch (SQLException e) {
            return true;
        }
    }
    public void editCourse(String id,String courseName,String courseCost){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE COURSES_INFO SET courseName='"+courseName+"',courseCost='"+courseCost+"' WHERE id="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCourse(String id) {
        try {
            Statement deleteCourseSt = connection.createStatement();
            deleteCourseSt.executeUpdate("DELETE FROM COURSES_INFO WHERE id='" + id + "';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTeacher(String name,String module,String course){
        try {
            Statement st = connection.createStatement();
            Statement st2 = connection.createStatement();
            st.executeUpdate("INSERT INTO TEACHER_INFO(Teacher_Name,Course_Name,Module_Name) VALUES('"+name+"','"+course+"','"+module+"');");
            System.out.println(name);
            System.out.println(course);
            st2.executeUpdate("UPDATE MODULES_INFO SET Teacher_Name ='"+name+"' WHERE Module_Name='"+module+"' AND Course_Name='"+course+"';");
            System.out.println(module);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void editTeacher(String id,String name,String course,String module){
        try {
            Statement st = connection.createStatement();
            Statement st1 =connection.createStatement();
            Statement st2 = connection.createStatement();
            st.executeUpdate("UPDATE TEACHER_INFO SET Teacher_Name='"+name+"',Course_Name='"+course+"',Module_Name='"+module+"' WHERE ID="+id);
            st1.executeUpdate("UPDATE MODULES_INFO SET Teacher_Name ='"+name+"' WHERE Module_Name='"+module+"' AND Course_Name='"+course+"';");
            st2.executeUpdate("UPDATE MODULES_INFO SET Module_Name ='"+module+"' WHERE Teacher_Name='"+name+"' AND Course_Name='"+course+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteTeacher(String id,String teacherName,String moduleName){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM TEACHER_INFO WHERE id='"+id+"';");
            st.executeUpdate("UPDATE MODULES_INFO SET TEACHER_NAME='Not Assigned' WHERE Teacher_Name='"+teacherName+"' AND Module_Name='"+moduleName+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void addModule(String courseName,String moduleName,String moduleType){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO MODULES_INFO(Module_Name,Course_Name,Module_Type) VALUES('"+moduleName+"','"+courseName+"','"+moduleType+"');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editModule(String id,String moduleName,String courseName,String moduleType){
        try {
            Statement st = connection.createStatement();
            Statement st1 = connection.createStatement();
            st.executeUpdate("UPDATE MODULES_INFO SET Module_Name='"+moduleName+"',Course_Name='"+courseName+"',Module_Type='"+moduleType+"' WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteModule(String id,String moduleName){
        try {
            Statement st = connection.createStatement();
            Statement st1=connection.createStatement() ;
            st.executeUpdate("DELETE FROM MODULES_INFO WHERE ID="+id);
            st1.executeUpdate("UPDATE TEACHER_INFO SET Module_Name='Not Available' WHERE Module_Name='"+moduleName+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                String name = String.valueOf(res.getString("studentName"));
                String course = String.valueOf(res.getString("courseName"));
                String[] tbData = {id, name, course};
                model.addRow(tbData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void fetchModuleTableData(JTable table){
        String query = "SELECT ID,Course_Name,Module_Name,Module_Type FROM Modules_INFO";
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
                String module = String.valueOf(res.getString("Module_Name"));
                String course = String.valueOf(res.getString("Course_Name"));
                String moduleType = String.valueOf(res.getString("Module_Type"));
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
                List.add(res.getString("courseName"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }catch (NullPointerException E){
            System.out.println("The database is empty");
        }
        return List;
    }
    public ArrayList<String> getModuleList(String courseName){
        ArrayList<String> data= new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM MODULES_INFO WHERE Course_Name='"+courseName+"';");
            while (res.next()){
                data.add(res.getString("Module_Name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    }
