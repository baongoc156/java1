/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3_4_ch5;

//import java.util.ArrayList;

import java.sql.SQLException;


/**
 *
 * @author DELL
 */
public class test {
    public static void main(String[] args) {
        QLBook qb = new QLBook();
        
        try {
            int id = 1234;
            String title = "ktlt";
            String author = "oanh";
            double price = 12.34;
            int qty = 12;
            Ebook eb = new Ebook(id, title, author, price, qty);
//            qb.add(eb);
            qb.updateInID(eb,1234);
            System.out.println("finish!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
