package Backend.Users;

import Data.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class Admin{

    private String username;
    private Database database = new Database();
    private Connection connection =database.connectToDatabase();

    public Admin(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addCourse(String courseName, String courseDescription, int courseCost, String[] moduleList) throws SQLException {
        //convert the list of modules into a single string
        String moduleListString = "";
        for(int i =0;i<moduleList.length;i++){
            moduleListString+= moduleList[i];
            moduleListString+= " ";
        }
        Statement addCourseSt = connection.createStatement();
        addCourseSt.executeUpdate("INSERT INTO COURSES_INFO(courseName,courseDescription,courseCost,moduleList,addedBy) VALUES ('"+courseName+"', '"+courseDescription+"', "+courseCost+",'"+moduleListString+"','"+username+"');");
    }

    public void addModule(String courseName,String newModuleName)throws  SQLException{
        String oldModuleList = "";
        Statement getModuleListSt = connection.createStatement();
        ResultSet res = getModuleListSt.executeQuery("SELECT * FROM COURSES_INFO;");
        while(res.next()){
            oldModuleList+=res.getString("moduleList");
        }
        Statement updateModuleSt = connection.createStatement();
        updateModuleSt.executeUpdate("UPDATE COURSES_INFO SET moduleList= '"+oldModuleList+newModuleName+"' WHERE courseName = '"+courseName+"';");
    }

    public void deleteCourse(String courseName)throws  SQLException{
        Statement deleteCourseSt = connection.createStatement();
        deleteCourseSt.executeUpdate("DELETE FROM COURSES_INFO WHERE courseName='"+courseName+"';");
    }

    public void updateCourse(String courseName, String courseDescription)throws SQLException{
        Statement updateCourseSt = connection.createStatement();
        updateCourseSt.executeUpdate("UPDATE COURSES_INFO SET courseDescription='"+courseDescription+"' WHERE courseName='"+courseName+"';");
    }

    public void updateCourse(String courseName, int courseCost)throws SQLException{
        Statement updateCourseSt = connection.createStatement();
        updateCourseSt.executeUpdate("UPDATE COURSES_INFO SET courseCost="+courseCost+" WHERE courseName='"+courseName+"';");
    }

    public void generateResult(String studentName) throws  SQLException{
        Statement generateResultSt = connection.createStatement();
        generateResultSt.executeUpdate("");
    }
    public HashMap<String, Integer> getCounts(){
        String studentQuery = "SELECT COUNT(*) FROM STUDENT_INFO;";
        String teacherQuery = "SELECT COUNT(*) FROM USERS_LOGIN_DATA WHERE ROLE='Teacher';";
        String courseQuery = "SELECT COUNT(*) FROM COURSES_INFO;";
        String moduleQuery = "SELECT COUNT(*) FROM MODULES_INFO;";
        HashMap<String,Integer> data = new HashMap<>();
        try {
            Statement studentSt = connection.createStatement();
            Statement teacherSt = connection.createStatement();
            Statement courseSt = connection.createStatement();
            Statement moduleSt = connection.createStatement();

            ResultSet student = studentSt.executeQuery(studentQuery);
            ResultSet teacher = teacherSt.executeQuery(teacherQuery);
            ResultSet course = courseSt.executeQuery(courseQuery);
            ResultSet module = moduleSt.executeQuery(moduleQuery);

            while (student.next()){data.put("student",student.getInt(1));}
            while (teacher.next()) {data.put("teacher",teacher.getInt(1));}
            while (course.next()) {data.put("course",course.getInt(1));}
            while(module.next()) {data.put("module",module.getInt(1));}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
