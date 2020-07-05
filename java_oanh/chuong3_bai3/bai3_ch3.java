package chuong3_bai3;

import java.util.Scanner;

public class bai3_ch3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        
        int num1=0;
        int num2=0;
        do {
            flag = false;
            try {
                System.out.print("Nhap vao so nguyen thu nhat: ");
                num1 = scanner.nextInt();

            } catch (Exception ex) {
                flag = true;
                System.out.println("Nhap lai: ");
                scanner.nextLine();
            }
        } while (flag);

        do {
            flag = false;
            try {
                System.out.print("Nhap vao so nguyen thu hai: ");
                num2 = scanner.nextInt();
                int num3=num1/num2;
            }
            catch(ArithmeticException ae){
                flag=true;
                System.out.println("Loi mau bang 0 => Nhap lai: ");
                scanner.nextLine();
            }catch (Exception ex) {
                flag = true;
                System.out.println("Nhap lai: ");
                scanner.nextLine();
            }
        } while (flag);
        
        
        
    }
}
