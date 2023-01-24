package Backend.Users;

import Backend.Interfaces.UserInterface;
import Data.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Admin implements UserInterface {

    private Connection connection;
    public void addCourse(){}
    public void addModule(){}
    public void deleteCourse(){}
    public void updateCourse(){}
    public void generateResult(){}

    public static void main(String[] args) {
        UserInterface.Login("Prabin","Chitwannepal#4");
    }
}
