package chuong1;

import java.util.Scanner;

public class Bai6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter degree Celsius: ");
        double celsius = input.nextDouble();
        double fahrenheit = (double) 9.0 / 5.0 * celsius + 32;
        System.out.printf("Conversion result: " + celsius +  " \"do C\" = " + fahrenheit + " \"do F\"");
    }

}
