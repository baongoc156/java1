/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8_BTTongHop;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 *
 * @author DELL
 */
public class Circle extends Shape implements Drawble {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double height) {
        this.radius = height;
    }

    public Circle() {
    }

    public Circle(double startX, double startY, double radius) {
        super(startX, startY);
        this.radius = radius;
    }

    public Circle(Point startPoint, double radius) {
        super(startPoint);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return radius * radius * 3.14;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * radius * 3.14;
    }

    @Override
    public void show() {
        System.out.printf("Circle{%2f,%2f,%2f}", getPoint().getX(), getPoint().getY(), radius);
    }

    @Override
    public String toString() {
        return "Circle{" + radius + '}';
    }

    @Override
    public void draw(Graphics2D g2d) {
        double x = getPoint().getX();
        double y = getPoint().getY();
        double d = radius * 2;

        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, d, d);

        Line2D.Double l1 = new Line2D.Double((x + radius), y, x + radius, y + d);
        Line2D.Double l2 = new Line2D.Double((x), y+radius, x + d, y + radius);
        
        g2d.draw(l2);
        g2d.draw(l1);
        g2d.draw(circle);
    }

}
