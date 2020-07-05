package chuong5_bai3_bai4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DataBaseUtil {

    public static Connection c;
    private static String db_url = "jdbc:mysql://localhost:3306/qlsach?characterEncoding=latin1&uesConfigs=maxPerformance";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws Exception {
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(db_url, username, password);
        }
        return c;
    }
    
    public static int setData(String sql)throws Exception
    {
        return getConnection().createStatement().executeUpdate(sql);
    }
    
    public static ResultSet getData(String sql) throws Exception{
        
        return getConnection().createStatement().executeQuery(sql);
        
    }

//    public void StoreProcedureCallDemo1() throws Exception {
////        public static void main(String[] args) {
//        try {
//            Connection conn = DataBaseUtil.getConnection();
//            CallableStatement statement;
//            statement = conn.prepareCall("{call create_author(?, ?)}");
//            statement.setString(1, "James Gosling");
//            statement.setString(2, "james@abc.com");
//            statement.execute();
//            statement.close();
//            conn.close();
//            System.out.println("Stored procedure called successfully!");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
////    }

}
