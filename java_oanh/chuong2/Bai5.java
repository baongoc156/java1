package chuong2;

import java.util.Scanner;
import java.util.Random;

public class Bai5 {

    public static void main(String[] args) {

        int startnumber = 0;
        int endnumber = 0;
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("Nhập phần tử bắt đầu: ");
        startnumber = scanner.nextInt();
        System.out.print("Nhập phần tử kết thúc: ");
        endnumber = scanner.nextInt();
        System.out.printf("Phần tử phát sinh ngẫu nhiên là:  ");
        number = startnumber + rd.nextInt(endnumber - startnumber);
        System.out.print(number + "\t");

    }
}
