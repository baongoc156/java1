package chuong2;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        System.out.print("Nhap bang cuu chuong k can tim: ");
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        System.out.printf("Bang cuu chuong %d can tim la: \n", k);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d \n", k, i, k * i);
        }
        System.out.println("Bang cuu chuong tu 2 den 9 la: ");
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%d\t", j, i, j * i);
            }
            System.out.printf("\n");
        }
    }
}
