package ch8_bai4;

public class ChuyenXeNoiThanh extends ChuyenXe {

    private String soTuyen;
    private int soKMDiDuoc;

    public String getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(String soTuyen) {
        this.soTuyen = soTuyen;
    }

    public int getSoKMDiDuoc() {
        return soKMDiDuoc;
    }

    public void setSoKMDiDuoc(int soKMDiDuoc) {
        this.soKMDiDuoc = soKMDiDuoc;
    }

    @Override
    public double TinhThuong() {
        return getDoanhThu() * 1.1;
    }

    public ChuyenXeNoiThanh() {
    }

    public ChuyenXeNoiThanh(String soTuyen, int soKMDiDuoc, String maSoChuyenXe, String hoTenTaiXe, String soXe, double doanhThu) {
        super(maSoChuyenXe, hoTenTaiXe, soXe, doanhThu);
        this.soTuyen = soTuyen;
        this.soKMDiDuoc = soKMDiDuoc;
    }

    @Override
    public String toString() {
        return String.format("Nội thành: %.0f, %.0f",getDoanhThu(),TinhThuong());
    }
}
