package QLSinhVien;

public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    public MonHoc() {
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public MonHoc(String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "maMonHoc=" + maMonHoc + ", tenMonHoc=" + tenMonHoc + ", soTinChi=" + soTinChi + '}';
    }
}
