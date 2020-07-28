package ch8_bai3;

public class TapChi extends TaiLieu{

    private String soPhatHanh;
    private int thangPhatHanh;

    public String getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(String soPhatHanh) {
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

    public TapChi(String soPhatHanh, int thangPhatHanh, String maSach, String tenNXB, String tenTaiLieu, double price) {
        super(maSach, tenNXB, tenTaiLieu, price);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String toString() {
        return "TapChi{" + "soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + '}';
    }
    
    
}
