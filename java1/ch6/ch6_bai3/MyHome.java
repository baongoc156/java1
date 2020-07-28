/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch6_bai3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author DELL
 */
public class MyHome {

    private double xLeft;
    private double yTop;
    private double ratio;

    public MyHome(double xLeft, double yTop, double ratio) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.ratio = ratio;
    }

    public void draw(Graphics2D g2) {
        Point2D.Double p1 = new Point2D.Double(xLeft + 4.5 * ratio, yTop + 0.5 * ratio);
        Point2D.Double p2 = new Point2D.Double(xLeft, yTop + 3.5 * ratio);
        Point2D.Double p3 = new Point2D.Double(xLeft + 9 * ratio, yTop + 3.5 * ratio);
        Point2D.Double p4 = new Point2D.Double(xLeft + 1 * ratio, yTop + 3 * ratio);
        Point2D.Double p5 = new Point2D.Double(xLeft + 8 * ratio, yTop + 3 * ratio);
        Point2D.Double p6 = new Point2D.Double(xLeft + 1 * ratio, yTop + 9 * ratio);
        Point2D.Double p7 = new Point2D.Double(xLeft + 8 * ratio, yTop + 9 * ratio);

        Line2D.Double roof1 = new Line2D.Double(p1, p2);
        Line2D.Double roof2 = new Line2D.Double(p1, p3);
        Line2D.Double body1 = new Line2D.Double(p4, p6);
        Line2D.Double body2 = new Line2D.Double(p5, p7);
        Line2D.Double body3 = new Line2D.Double(p6, p7);

        Rectangle.Double door = new Rectangle.Double(xLeft + 2 * ratio, yTop + 4 * ratio, 2 * ratio, 5 * ratio);
        Ellipse2D.Double window = new Ellipse2D.Double(xLeft + 5 * ratio, yTop + 4 * ratio, 2 * ratio, 2 * ratio);

        g2.setStroke(new BasicStroke(2));
        g2.draw(roof1);
        g2.draw(roof2);
        g2.draw(body1);
        g2.draw(body2);
        g2.draw(body3);
        g2.setPaint(Color.GREEN);
        g2.fill(door);
        g2.setPaint(Color.BLACK);
        g2.draw(door);
        g2.setColor(Color.YELLOW);
        g2.fill(window);
        g2.setPaint(Color.BLACK);
        g2.draw(window);
    }
}
