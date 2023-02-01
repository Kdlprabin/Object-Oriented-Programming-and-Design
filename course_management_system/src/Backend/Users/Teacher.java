package Backend.Users;

import Data.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Teacher {
    private String username;
    private ArrayList<String> modules;
    Database database = new Database();
    private Connection connection = database.connectToDatabase();

    public Teacher(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
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
    public void addMarks(String studentName,int marks)throws SQLException{
        Statement addMarksSt = connection.createStatement();
        addMarksSt.executeUpdate("UPDATE ENROLLMENT SET obtainedMarks="+marks+" WHERE studentName='"+studentName+"';");
    }
}
