/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch7_bai1;
/**
 *
 * @author DELL
 */
public class NhanVien {
    private String maNV;
    private String name;
    private double doanhThu;

    public NhanVien(String maNV, String name, double doanhThu) {
        this.maNV = maNV;
        this.name = name;
        this.doanhThu = doanhThu;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", name=" + name + ", doanhThu=" + doanhThu + '}';
    }
    
    
    
}
