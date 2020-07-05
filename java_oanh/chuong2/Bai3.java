package chuong2;

import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = input.nextInt();
        int tong = 0;
        for (int i = 0; i <= n; i++) {
            if (n % 2 == 0) {
                if (i % 2 == 0) {
                    tong += i;
                }
            } else {
                if (i % 2 != 0) {
                    tong += i;
                }
            }
        }
        System.out.print("Tong la: " + tong);
    }
}
