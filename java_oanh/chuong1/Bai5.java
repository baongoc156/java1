package chuong1;

import java.util.Scanner;

public class Bai5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount of seconds: ");
        int seconds = input.nextInt();
        int hours = seconds / 3600;
        int minute = seconds % 3600 / 60;
        seconds = seconds % 3600 % 60;
        System.out.printf("Result: %02d:%02d:%02d", hours, minute, seconds);

    }
}
