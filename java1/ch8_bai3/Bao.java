package ch8_bai3;

import java.util.Date;

public class Bao extends TaiLieu{
    private Date ngayPhatHanh;

    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Bao() {
        ngayPhatHanh = new Date();
    }

    public Bao(Date ngayPhatHanh, String maSach, String tenNXB, String tenTaiLieu, double price) {
        super(maSach, tenNXB, tenTaiLieu, price);
        this.ngayPhatHanh = ngayPhatHanh;
    }
    
    @Override
    public double chuongTrinhKhuyenMai() {
        if (ngayPhatHanh.getDate()==15) {
            setPrice(getPrice()*0.9);
        }
        return getPrice();
    }
    
    @Override
    public String toString() {
        return "Bao{" + "ngayPhatHanh=" + ngayPhatHanh + '}';
    }
}
