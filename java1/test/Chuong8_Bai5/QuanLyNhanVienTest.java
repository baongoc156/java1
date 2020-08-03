/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong8_Bai5;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author DELL
 */
public class QuanLyNhanVienTest {
    
    public QuanLyNhanVienTest() {
    }

    @Test
    public void testAdd() {
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

        QuanLyNhanVien ql2 = new QuanLyNhanVien();
        ql2.add(nvct1);
        ql2.add(nvct2);
        ql2.add(nvhd1);
        ql2.add(nvhd2);
        ql2.add(nvtv1);

        Assert.assertEquals(ql, null);
    }
}
