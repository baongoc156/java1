/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch6_test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Ch6_test {

    public Ch6_test(){
        JFrame f = new JFrame("Nguyễn Tiền");
        
        FlowLayout fl = new FlowLayout();

        Container ctn = f.getContentPane();

        JButton bLeft = new JButton("Left");
        JButton bCenter = new JButton("Center");
        JButton bRight = new JButton("Right");

        ctn.add(bLeft);
        ctn.add(bCenter);
        ctn.add(bRight);

        f.setLayout(fl);

        bLeft.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.LEFT);
            fl.layoutContainer(ctn);
        });

        bRight.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.RIGHT);
            fl.layoutContainer(ctn);
        });
        
        bCenter.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.CENTER);
            fl.layoutContainer(ctn);
        });

        f.setSize(700, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
