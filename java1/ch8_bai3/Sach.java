package ch8_bai3;

public class Sach extends TaiLieu{
    private String tenTG;
    private int soTrang;

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public Sach() {
    }

    public Sach(String tenTG, int soTrang, String maSach, String tenNXB, String tenTaiLieu, double price) {
        super(maSach, tenNXB, tenTaiLieu, price);
        this.tenTG = tenTG;
        this.soTrang = soTrang;
    }

    @Override
    public double chuongTrinhKhuyenMai() {
        if (tenTG.equals("ABC")) {
            setPrice(getPrice()*0.95);
        }
        return getPrice();
    }
    
    @Override
    public String toString() {
        return "Sach{" + "tenTG=" + tenTG + ", soTrang=" + soTrang + '}';
    }
}
