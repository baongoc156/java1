/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch6_test;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class BorderLayoutDemo {

    public BorderLayoutDemo() {
        JFrame jf = new JFrame("Nguyễn Tiền");
        
        BorderLayout bl = new BorderLayout();
        
        bl.setHgap(10);
        bl.setVgap(10);
        
        JButton b1 = new JButton("top");
        JButton b2 = new JButton("Left");
        JButton b3 = new JButton("right");
        JButton b4 = new JButton("bot");
        JButton b5 = new JButton("mid");
        
        jf.add(b1,BorderLayout.NORTH);
        jf.add(b2,BorderLayout.WEST);
        jf.add(b3,BorderLayout.EAST);
        jf.add(b4,BorderLayout.SOUTH);
        jf.add(b5,BorderLayout.CENTER);
        
        jf.setLayout(bl);
        
        jf.setSize(1000, 500);
        jf.setVisible(true);
    }
}
