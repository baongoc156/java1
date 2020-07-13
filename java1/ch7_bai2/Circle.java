package ch7_bai2;

public class Circle {

    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle() {
        java.util.Random rd = new java.util.Random();
        radius = rd.nextInt(40)+10;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getAcreage(){
        return this.radius * this.radius * 3.14;
    }

    @Override
    public boolean equals(Object obj) {
        Circle c = (Circle) obj;
        return this.getAcreage() == c.getAcreage(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.radius;
        return hash;
    }
    
    @Override
    public String toString() {
        return "Circle{" + "Acreage=" + getAcreage() + '}';
    }
}
