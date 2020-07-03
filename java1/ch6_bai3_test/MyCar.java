/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch6_bai3_test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/**
 *
 * @author DELL
 */
public class MyCar extends JComponent {

    private int xLeft;
    private int yTop;
    private int ratio;

    public MyCar(int xLeft, int yTop, int ratio) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.ratio = ratio;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle body = new Rectangle(xLeft, yTop + 10 * ratio, 60 * ratio, 10 * ratio);

        Point2D.Double p1 = new Point2D.Double(xLeft + 20 * ratio, yTop);
        Point2D.Double p2 = new Point2D.Double(xLeft + 40 * ratio, yTop);
        Point2D.Double p3 = new Point2D.Double(xLeft + 10 * ratio, yTop + 10 * ratio);
        Point2D.Double p4 = new Point2D.Double(xLeft + 50 * ratio, yTop + 10 * ratio);

        Ellipse2D.Double wheel1 = new Ellipse2D.Double(xLeft + 10*ratio, yTop + 20 * ratio, 10 * ratio, 10 * ratio);
        Ellipse2D.Double wheel2 = new Ellipse2D.Double(xLeft + 40*ratio, yTop + 20 * ratio, 10 * ratio, 10 * ratio);

        Line2D.Double frontWindshield = new Line2D.Double(p2, p4);
        Line2D.Double rearWindshield = new Line2D.Double(p1, p3);
        Line2D.Double roofTop = new Line2D.Double(p1, p2);

        g2.draw(body);
        g2.draw(wheel1);
        g2.draw(wheel2);
        g2.draw(frontWindshield);
        g2.draw(rearWindshield);
        g2.draw(roofTop);
    }

}
