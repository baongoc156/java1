/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2_ch5;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class QLUser {
    public void add(user u) throws SQLException {
        String sql = "insert into user values('" + u.getId() + "','" + u.getPass()+ "')";
        DataBaseUtil.setData(sql);
    }
    public void updateInStudenID(String newPassword, String userName) throws SQLException {
        String sql = String.format("update user set password = '%s' where username = '%s'", newPassword,userName);
        DataBaseUtil.setData(sql);
    }
    public boolean logIn(user u) throws SQLException{
        String sql = "select password from user where username = '"+u.getId()+"'";
        ResultSet rs = DataBaseUtil.getData(sql);
        rs.next();
        return rs.getString(1).equals(u.getPass());
    }
}
