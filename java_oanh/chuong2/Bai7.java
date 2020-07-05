package chuong2;

import java.util.Random;
import java.util.Scanner;

public class Bai7 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lần tung xí ngầu: ");
        int n = scanner.nextInt();
        int[] arr = taomangrandom(n);
        System.out.println("Số chấm của xí ngầu sau mỗi lần tung là: ");
        inmangrandom(arr);
        count(arr);
    }
    
    public static int[] taomangrandom(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(6) + 1;
        }
        return arr;
    }
    
    public static void count(int[] arr) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count1++;
            }
            if (arr[i] == 2) {
                count2++;
            }
            if (arr[i] == 3) {
                count3++;
            }
            if (arr[i] == 4) {
                count4++;
            }
            if (arr[i] == 5) {
                count5++;
            }
            if (arr[i] == 6) {
                count6++;
            }
            
        }
        System.out.printf("Số lần xuất hiện của mặt 1 chấm là: %d %n", count1);
        System.out.printf("Số lần xuất hiện của mặt 2 chấm là: %d %n", count2);
        System.out.printf("Số lần xuất hiện của mặt 3 chấm là: %d %n", count3);
        System.out.printf("Số lần xuất hiện của mặt 4 chấm là: %d %n", count4);
        System.out.printf("Số lần xuất hiện của mặt 5 chấm là: %d %n", count5);
        System.out.printf("Số lần xuất hiện của mặt 6 chấm là: %d %n", count6);
        
    }

    public static void inmangrandom(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("\tLần %d: %d chấm %n", i, arr[i]);
        }
    }
}
