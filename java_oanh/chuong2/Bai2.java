package chuong2;

import java.util.Scanner;

public class Bai2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String chuoi;
        char kyTu;
        System.out.print("Nhap vao mot chuoi bat ky: ");
        chuoi = input.nextLine();
        System.out.println("Ky tu dau trong chuoi la: ");
        kyTu = chuoi.charAt(0);
        System.out.print(kyTu + "\t");
        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) == ' ' && chuoi.charAt(i + 1) != ' ') {
                kyTu = chuoi.charAt(i + 1);
                System.out.print(kyTu + "\t");
            }

        }
    }

}
