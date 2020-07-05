/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuong5_bai3_bai4;

import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class QLSach {

    public void getBook() throws Exception {
        String sql = "Select * from sach";
        ResultSet rs = DataBaseUtil.getData(sql);
        System.out.println("+-------+------------------------------+---------------+---------+-------+");
        System.out.printf("%-8s", "| id");
        System.out.printf("%-31s", "| title");
        System.out.printf("%-16s", "| author");
        System.out.printf("%-10s", "| price");
        System.out.printf("%-8s", "| qty");
        System.out.println("|");
        System.out.printf("%-8s", "|(INT)");
        System.out.printf("%-31s", "|(VARCHAR(50))");
        System.out.printf("%-16s", "|(VARCHAR(50))");
        System.out.printf("%-10s", "|(FLOAT)");
        System.out.printf("%-8s", "|(INT)");
        System.out.println("|");
        System.out.println("+-------+------------------------------+---------------+---------+-------+");

        while (rs.next()) {
            int id = rs.getInt(1);
            String title = rs.getString(2);
            String author = rs.getString(3);
            float price = rs.getFloat(4);
            int qty = rs.getInt(5);
            System.out.printf("%-8s", "| " + id);
            System.out.printf("%-31s", "| " + title);
            System.out.printf("%-16s", "| " + author);
            System.out.printf("%-10s", "| " + price);
            System.out.printf("%-8s", "| " + qty);
            System.out.println("|");
        }
        System.out.println("+-------+------------------------------+---------------+---------+-------+");
    }

    public void tangGiaSach() throws Exception {
        String sql = "select * from sach where title='A Cup of Java'";
        ResultSet rs = DataBaseUtil.getData(sql);
        float price = 0;
        while (rs.next()) {
            price = rs.getFloat(4) + rs.getFloat(4) * (float) 0.5;
        }
        String sql1 = "update sach set price=" + price + "where title='A Cup of Java'";
        DataBaseUtil.setData(sql1);
    }

    public void thayDoiSL() throws Exception {
        String sql = "update sach set qty=0 where title='A teaspoon of Java'";
        DataBaseUtil.setData(sql);

    }

    public void delete() throws Exception {
        String sql = "delete from sach where id>6000";
        DataBaseUtil.setData(sql);
    }

    public void insert() throws Exception {
        String sql = "insert into sach values(6001,'JavaABC','Mr Author',15.55,55)";
        String sql1 = "insert into sach values(8002,'JavaXYZ','Mr Author',25.55,55)";
        DataBaseUtil.setData(sql);
        DataBaseUtil.setData(sql1);
    }
}
