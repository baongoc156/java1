/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch7_bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author DELL
 */
public class test {

    public static void main(String[] args) {
        ArrayList<NhanVien> l = new ArrayList<>();
        l.add(new NhanVien("100", "tien", 1000000));
        l.add(new NhanVien("101", "tiennguyen", 2000000));
        l.add(new NhanVien("102", "nguyentien", 1500000));
        l.add(new NhanVien("103", "okane", 900000));
        l.add(new NhanVien("104", "tientien", 1100000));

        List l1 = l;

        Collections.sort(l1, (NhanVien s1, NhanVien s2) -> {
            if (s1.getDoanhThu() == s2.getDoanhThu()) {
                return 0;
            } else if (s1.getDoanhThu() > s2.getDoanhThu()) {
                return 1;
            } else {
                return -1;
            }
        });
        
        l.forEach(System.out::println);
    }
}
