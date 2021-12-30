package GUI_CW_DB;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseUtil {
    public static int tableLength = 0;
    public  static Connection getDBConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/GUI";
            String username = "root";
            String password = "0piosolo";
            Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return con;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static ResultSet results(String table, String where){
        String command;

        if(!where.equals("none")){
            command = "SELECT * FROM "+table+" where "+where;
        }else {
            command = "SELECT * FROM "+table;
        }
        try {
            Connection con = getDBConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            ResultSet rs = con.createStatement().executeQuery("select count(*) from "+table);
            rs.next();
            tableLength = rs.getInt("count(*)");
            return  resultSet;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void record(String table,String values){
        try {
            Connection con = getDBConnection();
            Statement statement = con.createStatement();
            String insert = "INSERT INTO "+table+" VALUES("+values+")";
            statement.executeUpdate(insert);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static boolean check(String table,String where){
        boolean out = false;
        String command = "SELECT * FROM "+table+" where "+where;
        try {
            Connection con = getDBConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            if (resultSet.next()){
                out = true;
            } else{
                out = false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return out;
    }
}
