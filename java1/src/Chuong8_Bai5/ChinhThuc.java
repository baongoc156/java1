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
public class ChinhThuc extends NhanVien implements TangCa {

    private int heSoLuong;
    private int soGioTangCa;

    public int getSoGioTangCa() {
        return soGioTangCa;
    }

    public void setSoGioTangCa(int soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public ChinhThuc(int heSoLuong, int soGioTangCa, String maSo, String hoTen) {
        super(maSo, hoTen);
        this.heSoLuong = heSoLuong;
        this.soGioTangCa = soGioTangCa;
    }

    public ChinhThuc() {
    }

    @Override
    public String toString() {
        return "NVCT - " + "Ho ten: " + getHoTen() + " - Ma so: " + getMaSo() + " - Luong: " + getLuong();
    }

    @Override
    public int getLuong() {
        return heSoLuong * 1150000 + getTangCa();
    }

    @Override
    public int getTangCa() {
        return soGioTangCa * 60000;
    }

}
