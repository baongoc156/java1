package bai3_4_ch5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtil {

    public static Connection c;
    public static String url = "jdbc:mysql://localhost:3306/ebookshop";
    public static String username = "root";
    public static String password = "";
    

    public static Connection GetConnection() throws SQLException {
        if (c==null) {
            c = DriverManager.getConnection(url, username, password);
        }
        return c;
    }
    public static int setData(String sql) throws SQLException{
        return GetConnection().createStatement().executeUpdate(sql);
    }
    public static ResultSet getData(String sql) throws SQLException{
        return GetConnection().createStatement().executeQuery(sql);
    }
}
