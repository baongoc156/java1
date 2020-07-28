/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch6_bai3;

import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class test {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Home");
        
        jf.setSize(400,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        HomeComponent hc = new HomeComponent();
        jf.add(hc);
        
        jf.setVisible(true);
    }
}
