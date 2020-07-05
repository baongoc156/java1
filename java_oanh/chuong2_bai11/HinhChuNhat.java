package chuong2_bai11;

public class HinhChuNhat {

    private double startX;
    private double startY;
    private double width;
    private double heigth;

    public HinhChuNhat() {
    }

    public HinhChuNhat(double startX, double startY, double width, double heigth) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.heigth = heigth;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public int kiemTraDiemThuoc(Diem khac) {

        if (khac.getX() < startX || khac.getX() > startX + this.width) {
            return 0;
        }
        if (khac.getY() < startY || khac.getY() > startY + this.heigth) {
            return 0;
        }
        return 1;
    }

    public int kiemTraHinhChuNhat(HinhChuNhat khac) {
        Diem a = new Diem(khac.getStartX(), khac.getStartY());
        Diem b = new Diem(khac.getWidth() + khac.getStartX(), khac.getStartY());
        Diem c = new Diem(khac.getWidth() + khac.getStartX(), khac.getStartY() + khac.getHeigth());
        Diem d = new Diem(khac.getStartX(), khac.getStartY() + khac.getHeigth());
        double xA = this.startX;
        double xB = this.startX + this.getWidth();
        double yA = this.startY;
        double yD = this.getStartY() + this.getHeigth();//Gọi tên theo thứ tự đỉnh của hình chữ nhật
        if (kiemTraDiemThuoc(a) == 1 || kiemTraDiemThuoc(b) == 1 || kiemTraDiemThuoc(c) == 1 || kiemTraDiemThuoc(d) == 1) {
            return 1;
        } else if (xA < a.getX() && xB > b.getX()) {
            if (yA < a.getY() && yD > d.getY() || yA > a.getY() && yD < d.getY()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {

        return this.width + "," + this.heigth;

    }
}
