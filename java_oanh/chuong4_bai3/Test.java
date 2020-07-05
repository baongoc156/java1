package chuong4_bai3;

import static chuong4_bai3.R_W_File.R_File;
import static chuong4_bai3.R_W_File.W_File;
import static chuong4_bai3.Sort.SortString;
import static chuong4_bai3.Sort.ConvertInt;
import static chuong4_bai3.Sort.SortIncrease;

public class Test {

    public static void main(String[] args) {
        String filePath = "NewText.txt";
        W_File(filePath);
        System.out.print("File duoc tao voi so nguyen ngau nhien: ");
        R_File(filePath);
        String[] str = SortString(filePath);
        try {
//            for (String str1 : str) {
//                System.out.print(str1 + " ");
//            }
//            System.out.println("");
//            for (int a : COnvertInt(str)) {
//                System.out.print(a + " ");
//            }
            System.out.print("File sau khi duoc sap xep: ");
            for (int b : SortIncrease(ConvertInt(str))) {
                System.out.print(b + "  ");
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

    }

}
