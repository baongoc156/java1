package ch8_bai4;

public class ChuyenXeNgoaiThanh extends ChuyenXe {

    private String noiDen;
    private int soNgayDiDuoc;

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public int getSoNgayDiDuoc() {
        return soNgayDiDuoc;
    }

    public void setSoNgayDiDuoc(int soNgayDiDuoc) {
        this.soNgayDiDuoc = soNgayDiDuoc;
    }

    @Override
    public double TinhThuong() {
        return getDoanhThu() * 1.05;
    }

    public ChuyenXeNgoaiThanh() {
    }

    public ChuyenXeNgoaiThanh(String noiDen, int soNgayDiDuoc, String maSoChuyenXe, String hoTenTaiXe, String soXe, double doanhThu) {
        super(maSoChuyenXe, hoTenTaiXe, soXe, doanhThu);
        this.noiDen = noiDen;
        this.soNgayDiDuoc = soNgayDiDuoc;
    }

    @Override
    public String toString() {
        return String.format("Ngoại thành: %.0f, %.0f", getDoanhThu(), TinhThuong());
    }
}
