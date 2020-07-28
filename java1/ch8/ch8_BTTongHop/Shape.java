/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8_BTTongHop;

/**
 *
 * @author DELL
 */
abstract class Shape {
    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Shape() {
    }

    public Shape(Point point) {
        this.point = point;
    }
    
    public Shape(double x,double y) {
        this.point = new Point(x, y);
    }
    
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract void show();
}
