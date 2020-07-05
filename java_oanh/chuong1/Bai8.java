package chuong1;

import java.util.Scanner;

public class Bai8 {

    public static int nhap() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while (!check) {
            try {
                n = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Bạn phải nhập số nguyên! Hãy nhập lại...");
                input.nextLine();
            }
        }
        return n;
    }

    public static int UCLN(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.print("Nhập a: ");
        int a = nhap();
        System.out.print("Nhập b: ");
        int b = nhap();

        System.out.println("UCLN cua " + a + " va " + b + " la " + UCLN(a, b));
        System.out.println("BCNN cua " + a + " va " + b + " la " + a * b / UCLN(a, b));
    }
}
