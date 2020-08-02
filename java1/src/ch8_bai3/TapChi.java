package ch8_bai3;

public class TapChi extends TaiLieu{

    private int soPhatHanh;
    private int thangPhatHanh;

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    public TapChi() {
    }

    public TapChi(int soPhatHanh, int thangPhatHanh, String maSach, String tenNXB, String tenTaiLieu, double price) {
        super(maSach, tenNXB, tenTaiLieu, price);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String toString() {
        return "TapChi{" + "soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + '}';
    }

    @Override
    public double chuongTrinhKhuyenMai() {
        if (soPhatHanh%2==0) {
            setPrice(getPrice() *0.9);
            return getPrice();
        }
        return getPrice();
    }
}
