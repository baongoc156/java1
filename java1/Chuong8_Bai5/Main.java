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
public class Main {

    public static void main(String[] args) {

        NhanVien nvct1 = new ChinhThuc(1, 2, "1", "oanh");
        NhanVien nvct2 = new ChinhThuc(2, 4, "2", "ngoc");
        NhanVien nvhd1 = new HopDong(10, 30, 1, "001", "uyen");
        NhanVien nvhd2 = new HopDong(20, 25, 0, "002", "tien");
        NhanVien nvtv1 = new ThoiVu(3, "001", "trinh");

        QuanLyNhanVien ql = new QuanLyNhanVien();
        ql.add(nvct1);
        ql.add(nvct2);
        ql.add(nvhd1);
        ql.add(nvhd2);
        ql.add(nvtv1);

        ql.inThongTinNhanVien();
        System.out.println(ql.demNVHD());
        ql.inInfoMax();
    }

}
