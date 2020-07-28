/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8_test;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Customer cus1 = new Customer("Oanh", "0123456798", "TPHCM");
        Customer cus2 = new Customer("Ngoc", "0123456798", "DongNai");
        Customer cus3 = new Customer("Uyen", "0123456798", "TPHCM");
        //
        Invoice inv1 = new Invoice("HD1", cus1);
        inv1.add(new Product("Book 1", 10000), 3);
        inv1.add(new Product("Book 2", 30000), 1);
        inv1.add(new Product("Book 3", 20000), 2);
        inv1.add(new Product("Book 4", 50000), 2);
        //
        Invoice inv2 = new Invoice("HD2", cus2);
        inv2.add(new Product("Book 2", 30000), 1);
        inv2.add(new Product("Book 3", 20000), 2);
        inv2.add(new Product("Book 4", 50000), 2);
        //
        Invoice inv3 = new Invoice("HD3", cus3);
        inv3.add(new Product("Book 1", 10000), 3);
        inv3.add(new Product("Book 2", 30000), 1);
        inv3.add(new Product("Book 3", 20000), 2);
        inv3.add(new Product("Book 4", 50000), 2);
        //
        InvoiceManagement list = new InvoiceManagement();
        list.add(inv1);
        list.add(inv2);
        list.add(inv3);
        //xuất danh sách hoá đơn
        System.out.println("Danh sach hoa don: ");
        list.getInvoiceList().forEach((x) -> System.out.println(x.getTotal()));
        //xoá phần tử khi biết tên
        if (list.remove("HD3") == true) {
            System.out.println("Da xoa thanh cong");
            System.out.println(list.format());
        } else {
            System.out.println("Xoa khong thanh cong");
        }
        //tim các hoá đơn có tổng tiền cao nhất
        System.out.println("Danh sach hoa don co tong tien cao nhat: ");
        list.findInvoicesMaxTotal().forEach(System.out::println);
        //tim hoá đơn khi biết tên
        list.findInvoiceName("Oanh").forEach(System.out::println);
        //sắp xếp
        list.Sort().forEach(System.out::println);
    }

}
