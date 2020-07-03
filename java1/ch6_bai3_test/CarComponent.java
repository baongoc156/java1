/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch6_bai3_test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 * @author DELL
 */
public class CarComponent extends JComponent {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        int tyle = 3;
        
        MyCar car1 = new MyCar(10, 10*tyle, tyle);
        MyCar car2 = new MyCar(10, 55*tyle, tyle);

        car1.draw(g2);
        car2.draw(g2);
    }
}
