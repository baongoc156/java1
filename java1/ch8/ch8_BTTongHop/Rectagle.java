/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8_BTTongHop;

import java.awt.Graphics2D;

/**
 *
 * @author DELL
 */
public class Rectagle extends Shape implements Drawble{

    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectagle() {
    }

    public Rectagle(double startX, double startY, double width, double height){
        super(startX,startY);
        this.width = width;
        this.height = height;
    }

    public Rectagle(Point startPoint, double width, double height) {
        super(startPoint);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (height + width);
    }

    @Override
    public void show() {
        System.out.printf("Rectagle(%2f,%2f,%2f,%2f)",getPoint().getX(),getPoint().getY(),width,height);
    }

    @Override
    public String toString() {
        return "Rectagle{" + "width=" + width + ", height=" + height + '}';
    }

    @Override
    public void draw(Graphics2D g2d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
