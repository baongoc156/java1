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
public abstract class NhanVien {

    private String maSo;
    private String hoTen;

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public NhanVien() {
    }

    public NhanVien(String maSo, String hoTen) {
        this.maSo = maSo;
        this.hoTen = hoTen;
    }

    @Override
    public abstract String toString();
    
    public abstract int getLuong(); 

}
