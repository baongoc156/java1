/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3_4_ch5;

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
        ResultSet rs = bai3_4_ch5.DataBaseUtil.getData(sql);
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
        String sql = "select * from books where id = " + id;
        ResultSet rs = bai3_4_ch5.DataBaseUtil.getData(sql);
        rs.next();
        String title = rs.getString(2);
        String author = rs.getString(3);
        double price = rs.getDouble(4);
        int qty = rs.getInt(5);
        return new Ebook(id, title, author, price, qty);
    }

    public void add(Ebook eb) throws SQLException {
        int id = eb.getId();
        String title = eb.getTitle();
        String author = eb.getAuthor();
        double price = eb.getPrice();
        int qty = eb.getQty();
        String sql = "insert into books values(" + id + ",'" + title + "','" + author + "'," + price + "," + qty + ")";
        bai3_4_ch5.DataBaseUtil.setData(sql);
    }

    public void removeInID(int id) throws SQLException {
        String sql = "delete from books where id=" + id ;
        bai3_4_ch5.DataBaseUtil.setData(sql);
    }

    public void updateInID(Ebook eb, int id) throws SQLException {
        int newid = eb.getId();
        String title = eb.getTitle();
        String author = eb.getAuthor();
        double price = eb.getPrice();
        int qty = eb.getQty();
        String sql = String.format("update books set id=%d , title = '%s', author = '%s',price = %f,qty = %d where id = %d", newid, title,author,price,qty ,id);
        bai3_4_ch5.DataBaseUtil.setData(sql);
    }
}
