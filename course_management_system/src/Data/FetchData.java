package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class FetchData {
    public HashMap<String,String> loginInfo= new HashMap<>();
    static Database database = new Database();
    static Connection connection = database.connectToDatabase();
    public HashMap<String,String> loginData(String username){
        try{
            Statement st = connection.createStatement();
            String statement = "SELECT * FROM adminInfo WHERE username='"+username+"';";
            ResultSet res = st.executeQuery(statement);
            while(res.next()){
                loginInfo.put("password",res.getString("password"));
            }
            loginInfo.put("username",username);
        }catch(Exception e){
            System.out.println(e);
        }
        return loginInfo;
    }
}
