/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong2;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class Bai4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Width: ");
        int width = input.nextInt();
        System.out.print("Enter Length: ");
        int length = input.nextInt();
        System.out.printf("Perimeter of Rectangle(%d,%d) : %d",width,length,(width+length)*2);
        System.out.printf("\nArea of Rectangle(%d,%d) : %d \n",width,length, width*length);
    }
}
