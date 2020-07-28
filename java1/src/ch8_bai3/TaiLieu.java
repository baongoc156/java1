package ch8_bai3;

abstract class TaiLieu {
    private String maSach;
    private String tenNXB;
    private String tenTaiLieu;
    private double price;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TaiLieu() {
    }

    public TaiLieu(String maSach, String tenNXB, String tenTaiLieu, double price) {
        this.maSach = maSach;
        this.tenNXB = tenNXB;
        this.tenTaiLieu = tenTaiLieu;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TaiLieu{" + "maSach=" + maSach + ", tenNXB=" + tenNXB + ", tenTaiLieu=" + tenTaiLieu + ", price=" + price + '}';
    }
}
