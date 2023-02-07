package Data;

import Backend.CustomDatatype.SignupData;
import Backend.Exceptions.NoTableFoundException;
import Backend.Exceptions.UserExistsException;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SendData {
    private Database database = new Database("Signup ");
    Connection connection = database.connectToDatabase();

    public void signupData(SignupData signupData) throws SQLException {
        Statement checkStatement = connection.createStatement();
        Statement st = connection.createStatement();
        Statement st1 = connection.createStatement();
        ResultSet res = checkStatement.executeQuery("SELECT * FROM USERS_LOGIN_DATA");
        while (res.next()) {
            String userStat = res.getString("USERNAME");
            if (userStat.equals(signupData.username)) {
                throw new UserExistsException();
            }
        }
        try {
            st.executeUpdate("INSERT INTO USERS_LOGIN_DATA(ROLE,USERNAME,EMAIL,PASSWORD) VALUES('" + signupData.role
                    + "','" + signupData.username + "','" + signupData.email + "','" + signupData.password + "');");
            switch (signupData.role) {
                case "teacher":
                    st1.executeUpdate("INSERT INTO TEACHER_INFO(TEACHER_NAME) VALUES('" + signupData.username + "');");
                    break;
                case "student":
                    st1.executeUpdate("INSERT INTO STUDENT_INFO(STUDENT_NAME) VALUES('" + signupData.username + "');");
            }
        } catch (SQLException e) {
            new CreateTables(connection);
            throw new NoTableFoundException();
        }
    }
}
