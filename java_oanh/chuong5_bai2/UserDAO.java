package chuong5_bai2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void addSV(user acc)throws Exception{
        String sql="insert into user values('"+acc.getUserName()+"','"+acc.getPassWord()+"')";
        DataBaseUtil.setData(sql);
    }
    public void updateSV(user newUser) throws SQLException, Exception {
        String sql = String.format("update user set password = '%s' where username = '%s'",newUser.getPassWord(),newUser.getUserName());
        DataBaseUtil.setData(sql);
    }
     public boolean checkLogIn(user acc) throws Exception {
        String sql="select * from user where username='"+acc.getUserName()+"'";
         ResultSet rs=DataBaseUtil.getData(sql);
         rs.next();
        return rs.getString("password").equals(acc.getPassWord());
    }
     
     
}
