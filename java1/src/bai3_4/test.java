/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3_4;

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
//            ArrayList<>
            for (Ebook ebook : qb.getAllEbook()) {
                System.out.println(ebook);
            }
        } catch (SQLException e) {
        }
    }
}
