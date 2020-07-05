package chuong2_bai11;

public class Diem {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Diem() {
    }

    public double tinhKhoangCachToiO() {
        x = Math.abs(x);
        y = Math.abs(y);
        double kCach = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return kCach;
    }

    public double tinhKhoangCachToiDiemKhac(chuong2_bai10.Diem khac) {
        this.setX(Math.abs(this.getX() - khac.getX()));
        this.setY(Math.abs(this.getY() - khac.getY()));
        double kCach = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        return kCach;
    }

    @Override
    public String toString() {
        return "Diem{" + "x=" + x + ", y=" + y + '}';
    }
}
