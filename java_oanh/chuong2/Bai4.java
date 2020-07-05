package chuong2;

public class Bai4 {

    public static void main(String[] args) {
        for (int i = 1; i < 256; i++) {
            System.out.print(i + "\t");
            System.out.print(Integer.toHexString(i).toUpperCase() + "\t");
            System.out.print(Integer.toBinaryString(i).toUpperCase() + "\t  ");
            System.out.print(Integer.toOctalString(i).toUpperCase() + "\t");
            System.out.println("");
        }
    }
}
