package Frontend;

import Database.CreateConnection;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Display extends JFrame{
    private JPanel Display;
    private JList list1;
    private JList list2;
    private JList list3;
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<String> firstList = new ArrayList<>();
    private ArrayList<String> lastList = new ArrayList<>();

    public Display(){
        CreateConnection connect = new CreateConnection();
        Connection connection = connect.con;
        try{
            Statement St = connection.createStatement();
            ResultSet res = St.executeQuery("Select * from week10");
            while(res.next()){
                idList.add(res.getInt("id"));
                firstList.add(res.getString("First_name"));
                lastList.add(res.getString("Last_name"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        setContentPane(Display);
        setSize(530,300);
        list1.setListData(idList.toArray());
        list2.setListData(firstList.toArray());
        list3.setListData(lastList.toArray());
        setVisible(true);
    }
}