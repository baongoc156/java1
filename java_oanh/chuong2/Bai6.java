package chuong2;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên dương bất kì: ");
        number = scanner.nextInt();
        String str = "";
        if (number < 1) {
            System.out.println("Invalid Roman Number Value");
        }
        System.out.print("Result (Dec to Roman): ");
        while (number >= 1000) {
            str += "M";
            number -= 1000;
        }

        while (number >= 900) {
            str += "CM";
            number -= 900;
        }

        while (number >= 500) {
            str += "D";
            number -= 500;
        }

        while (number >= 400) {
            str += "CD";
            number -= 400;
        }

        while (number >= 100) {
            str += "C";
            number -= 100;
        }

        while (number >= 90) {
            str += "XC";
            number -= 90;
        }

        while (number >= 50) {
            str += "L";
            number -= 50;
        }

        while (number >= 40) {
            str += "XL";
            number -= 40;
        }

        while (number >= 10) {
            str += "X";
            number -= 10;
        }

        while (number >= 9) {
            str += "IX";
            number -= 9;
        }

        while (number >= 5) {
            str += "V";
            number -= 5;
            while (number >= 1) {
                str += "I";
                number -= 1;
            }
        }

        while (number >= 4) {
            str += "IV";
            number -= 4;
        }

        while (number >= 1) {
            str += "I";
            number -= 1;
        }

        System.out.print(str + "\t");
    }
}
