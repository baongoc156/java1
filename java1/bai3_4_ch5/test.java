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
//            int id = 6001;
//            String title = "Java ABC";
//            String author = "Mr Author";
//            double price = 15.55;
//            int qty = 55;
//            Ebook eb = new Ebook(id, title, author, price, qty);

            int id = 8002;
            String title = "Java XYZ";
            String author = "Mr Author";
            double price = 25.55;
            int qty = 55;
            Ebook eb = new Ebook(id, title, author, price, qty);
            qb.add(eb);

            System.out.println("finish!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
