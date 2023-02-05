package Backend.Users;

import Data.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Teacher extends User{
    private final String username;
    private String email;
    private ArrayList<String> modules;

    Database database = new Database();
    private final Connection connection = database.connectToDatabase();

    public Teacher(String username) {
        this.username = username;
        setEmail();

    }
    public String getUsername() {
        return username;
    }

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

    public ArrayList<String> viewModule()throws SQLException {
        ArrayList<String> modules = new ArrayList<>();
        Statement viewModuleSt = connection.createStatement();
        ResultSet res = viewModuleSt.executeQuery("SELECT * FROM MODULES_INFO WHERE TEACHER = '"+username+"';");
        while(res.next()){
            modules.add(res.getString("moduleName"));
        }
        this.modules= modules;
        return modules;
    }
    public void viewStudents() throws SQLException{
        HashMap<String,ArrayList<String>> studentsModules = new HashMap<>();
        Statement viewStudentsSt = connection.createStatement();
        for(String s:modules){
            ArrayList<String> students = new ArrayList<>();
            ResultSet res = viewStudentsSt.executeQuery("SELECT * FROM ENROLLMENT WHERE moduleName='"+s+"';");
            while(res.next()){
                students.add(res.getString("studentName"));
            }
            studentsModules.put(s,students);
        }
    }

    public HashMap<String, Integer> getCounts() {
        String studentQuery = "SELECT COUNT(*) FROM STUDENT_INFO;";
        String teacherQuery = "SELECT COUNT(*) FROM TEACHER_INFO";
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
    public void addMarks(String studentName,String moduleName,String marks){
        try {
            Statement addMarksSt = connection.createStatement();
            addMarksSt.executeUpdate("UPDATE ENROLLMENT SET marksObtained="+marks+" WHERE studentName='"+studentName+"' AND moduleName='"+moduleName+"';");
            System.out.println("updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editMarks(String id,String name,String module,String marks){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE ENROLLMENT SET studentName='"+name+"',moduleName='"+module+"',marksObtained='"+marks+"' WHERE ID="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deleteMarks(String id){
        try {
            Statement addMarksSt = connection.createStatement();
            addMarksSt.executeUpdate("UPDATE ENROLLMENT SET marksObtained=0 WHERE id="+id);
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addModule(String courseName,String moduleName,String teacherName,String moduleType){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO MODULES_INFO(Module_Name,Course_Name,Teacher_Name,Module_Type) VALUES('"+moduleName+"','"+courseName+"','"+teacherName+"',"+moduleType+");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editModule(String id,String moduleName,String courseName,String teacherName,String moduleType){
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE TEACHER_INFO SET Module_Name='"+moduleName+"',Course_Name='"+courseName+"',Teacher_Name='"+teacherName+"',Module_Type="+moduleType+" WHERE ID="+id);
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
        String query = "SELECT * FROM ENROLLMENT";
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
    public String getCourseName() {
        String courseName = null;
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * from MODULES_INFO WHERE Teacher_Name='"+username+"';");
            while (res.next()) {
                courseName=res.getString("courseName");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }catch (NullPointerException E){
            System.out.println("The database is empty");
        }
        return courseName;
    }
    public ArrayList<String> getModuleList(){
        ArrayList<String> data= new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            System.out.println(username);
            ResultSet res = st.executeQuery("SELECT * FROM MODULES_INFO WHERE Teacher_Name='"+username+"';");
            while (res.next()){
                data.add(res.getString("Module_Name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public void fetchModuleTableData(JTable table,String teacherName){
        String query = "SELECT ID,Course_Name,Module_Name,Module_Type FROM Modules_INFO WHERE Teacher_Name='"+teacherName+"';";
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
    }
