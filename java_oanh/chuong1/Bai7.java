package chuong1;

import java.util.Scanner;

public class Bai7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Weight In Kilograms: ");
        double weight = input.nextDouble();
        System.out.print("Enter Height In Meters: ");
        double height = input.nextDouble();
        double BMI = weight / (height * height);
        if (BMI < 18.5) {
            System.out.println("Underweight");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            System.out.println("Normal");
        } else if (BMI >= 25 && BMI <= 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obesee");
        }

    }
}
