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
public class HopDong extends NhanVien implements TangCa {

    private int luongCB;
    private int soNgayCong;
    private int soGioTangCa;

    public int getSoGioTangCa() {
        return soGioTangCa;
    }

    public void setSoGioTangCa(int soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

    public int getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(int luongCB) {
        this.luongCB = luongCB;
    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public HopDong(int luongCB, int soNgayCong, int soGioTangCa, String maSo, String hoTen) {
        super(maSo, hoTen);
        this.luongCB = luongCB;
        this.soNgayCong = soNgayCong;
        this.soGioTangCa = soGioTangCa;
    }

    public HopDong() {
    }

    @Override
    public String toString() {
        return "NVHD - " + "Ho ten: " + getHoTen() + " - Ma so: " + getMaSo() + " - Luong: " + getLuong();

    }

    @Override
    public int getLuong() {
        return luongCB * soNgayCong / 30 + getTangCa();
    }

    @Override
    public int getTangCa() {
        return soGioTangCa * 60000;
    }

}
