/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong6;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Admin
 */
public class MyHome {

    private final int xLeft;
    private final int yTop;

    /**
     * @param x
     * @param y
     */
    public MyHome(int x, int y) {
        this.xLeft = x;
        this.yTop = y;
    }

    /**
     * @param g2
     */
    public void raw(Graphics2D g2) {
        Rectangle hcn = new Rectangle(xLeft + 30, yTop + 40, 20, 50);
        Ellipse2D.Double ellip = new Ellipse2D.Double(xLeft + 60, yTop + 40, 20, 15);
        Point2D.Double r1 = new Point2D.Double(xLeft + 10, yTop + 35);
        Point2D.Double r2 = new Point2D.Double(xLeft + 55, yTop + 10);
        Point2D.Double r3 = new Point2D.Double(xLeft + 100, yTop + 35);
        Point2D.Double r4 = new Point2D.Double(xLeft + 20, yTop + 30);
        Point2D.Double r5 = new Point2D.Double(xLeft + 20, yTop + 90);
        Point2D.Double r6 = new Point2D.Double(xLeft + 90, yTop + 90);
        Point2D.Double r7 = new Point2D.Double(xLeft + 90, yTop + 30);
        Line2D.Double l1 = new Line2D.Double(r1, r2);
        Line2D.Double l2 = new Line2D.Double(r2, r3);
        Line2D.Double l3 = new Line2D.Double(r4, r5);
        Line2D.Double l4 = new Line2D.Double(r5, r6);
        Line2D.Double l5 = new Line2D.Double(r6, r7);
        g2.draw(l1);
        g2.draw(l2);
        g2.draw(l3);
        g2.draw(l4);
        g2.draw(l5);
        g2.setColor(Color.GREEN);
        g2.fill(hcn);
        g2.setColor(Color.BLACK);
        g2.draw(hcn);
        g2.setColor(Color.YELLOW);
        g2.fill(ellip);
        g2.setColor(Color.BLACK);
        g2.draw(ellip);

    }
}
