/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3_4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class QLBook {
     public ArrayList<Ebook> getAllEbook() throws SQLException {
        String sql = "select * from books";
        ResultSet rs = bai2.DataBaseUtil.getData(sql);
        ArrayList<Ebook> Ebooks = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt(1);
            String title = rs.getString(2);
            String author = rs.getString(3);
            double price = rs.getDouble(4);
            int qty = rs.getInt(5);
            Ebooks.add(new Ebook(id, title, author, price, qty));
        }

        return Ebooks;
    }

    public Ebook getInID(int id) throws SQLException {
        String sql = "select * from sv where student_id = '" + student_id + "';";
        ResultSet rs = bai2.DataBaseUtil.getData(sql);
        rs.next();
        return new SV(rs.getString(1), rs.getString(2), rs.getString(3));
    }
//
//    public void add(SV sv) throws SQLException {
//        String sql = "insert into sv values('" + sv.getStudent_id() + "','" + sv.getName() + "','" + sv.getEmail() + "')";
//        bai2.DataBaseUtil.setData(sql);
//    }
//
//    public void removeInStudentID(String student_id) throws SQLException {
//        String sql = "delete from sv where student_id='" + student_id + "'";
//        bai2.DataBaseUtil.setData(sql);
//    }
//
//    public void updateInStudenID(SV sv, String student_id) throws SQLException {
//        String sql = String.format("update sv set student_id='%s' , name = '%s', email = '%s' where student_id = '%s'", sv.getStudent_id(), sv.getName(), sv.getEmail(), student_id);
//        bai2.DataBaseUtil.setData(sql);
//    }
}
