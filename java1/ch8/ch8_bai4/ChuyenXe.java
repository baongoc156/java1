package ch8_bai4;

abstract class ChuyenXe {
    private String maSoChuyenXe;
    private String hoTenTaiXe;
    private String soXe;
    private double doanhThu;

    public String getMaSoChuyenXe() {
        return maSoChuyenXe;
    }

    public void setMaSoChuyenXe(String maSoChuyenXe) {
        this.maSoChuyenXe = maSoChuyenXe;
    }

    public String getHoTenTaiXe() {
        return hoTenTaiXe;
    }

    public void setHoTenTaiXe(String hoTenTaiXe) {
        this.hoTenTaiXe = hoTenTaiXe;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public ChuyenXe() {
    }

    public ChuyenXe(String maSoChuyenXe, String hoTenTaiXe, String soXe, double doanhThu) {
        this.maSoChuyenXe = maSoChuyenXe;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }
    
    public abstract double TinhThuong();

    @Override
    public String toString() {
        return "ChuyenXe{" + "maSoChuyenXe=" + maSoChuyenXe + ", hoTenTaiXe=" + hoTenTaiXe + ", soXe=" + soXe + ", doanhThu=" + doanhThu + '}';
    }
}
