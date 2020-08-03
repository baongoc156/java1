/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong8_Bai5;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QuanLyNhanVien {

    ArrayList<NhanVien> dsnv = new ArrayList<>();

    public ArrayList<NhanVien> getDsnv() {
        return dsnv;
    }

    public void setDsnv(ArrayList<NhanVien> dsnv) {
        this.dsnv = dsnv;
    }

    public QuanLyNhanVien() {
        dsnv = new ArrayList<>();
    }

    public void add(NhanVien nv) {
        dsnv.add(nv);
    }

    public int demNVHD() {
        int dem = 0;
        for (NhanVien nhanVien : dsnv) {
            if (nhanVien instanceof HopDong) {
                dem++;
            }
        }
        return dem;
    }

    public int getLuongMax() {
        int max = 0;
        max = dsnv.get(0).getLuong();
        for (int i = 1; i < dsnv.size(); i++) {
            if (max < dsnv.get(i).getLuong()) {
                max = dsnv.get(i).getLuong();
            }
        }
        return max;
    }
    
    public void inInfoMax(){
        for (NhanVien nhanVien : dsnv) {
            if (nhanVien.getLuong()==getLuongMax()) {
                System.out.println(nhanVien.toString());
            }
        }
    }
    
    public void inThongTinNhanVien(){
        for (NhanVien nhanVien : dsnv) {
            System.out.println(nhanVien.toString());
        }
    }
}
