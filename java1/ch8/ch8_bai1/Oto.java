package ch8_bai1;

public class Oto extends Car {

    private int soCho;
    private double trongTai;

    public int getSoCho() {
        return soCho;
    }

    public void setSoCho(int soCho) {
        this.soCho = soCho;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    public Oto() {
    }

    public Oto(int soCho, double trongTai, String nhanHieu, double gia, int namSanXuat) {
        super(nhanHieu, gia, namSanXuat);
        this.soCho = soCho;
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("%-20s%s%n","Nhãn hiệu:",getNhanHieu()));
        sb.append(String.format("%-20s%s%n","Giá:",getGia()));
        sb.append(String.format("%-20s%s%n","Năm sản xuất:",getNamSanXuat()));
        sb.append(String.format("%-20s%s%n","So cho:",getSoCho()));
        sb.append(String.format("%-20s%s%n","Trọng tải:",getTrongTai()));
        
        return sb.toString();
    }
}
