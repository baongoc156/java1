/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong8_Bai5;

/**
 *
 * @author Admin
 */
public class ThoiVu extends NhanVien {

    private int soGioLam;

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public ThoiVu(int soGioLam, String maSo, String hoTen) {
        super(maSo, hoTen);
        this.soGioLam = soGioLam;
    }

    public ThoiVu() {
    }

    @Override
    public String toString() {
        return "NVTV - "+"Ho ten: "+getHoTen()+" - Ma so: "+getMaSo()+" - Luong: "+ getLuong();
    }

    @Override
    public int getLuong() {
        return soGioLam * 50000;
    }

}
