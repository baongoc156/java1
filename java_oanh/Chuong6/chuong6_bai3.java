/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong6;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class chuong6_bai3 extends JFrame {

    public static void main(String[] args) {
        chuong6_bai3 main = new chuong6_bai3();
        HomeComponent component = new HomeComponent();
        main.add(component);
    }

    public chuong6_bai3() {
        this.setTitle("My Home");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
