/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch6_bai3_test;

import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class test {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        
        jf.setSize(300, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CarComponent cc = new CarComponent();
        jf.add(cc);
        
        jf.setVisible(true);
    }
}
