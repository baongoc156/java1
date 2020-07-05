package chuong4_bai5;

import static chuong4_bai5.R_Binary.R_NumBin;
import static chuong4_bai5.R_Binary.SizeFileBin;
import static chuong4_bai5.R_Binary.SizeFileText;
import static chuong4_bai5.R_Binary.W_NumBin;
import static chuong4_bai5.R_Binary.W_NumText;

public class Test_ch4_bai5 {

    public static void main(String[] args) {
        String numText = "D:\\LuuThiKieuOanh_CD19TT9\\Java\\BaiTap\\Cacchuong\\src\\chuong4_bai5\\NumText.txt";
        String numBin = "NumBin.dat";
        W_NumText(numText);
        //Tạo file nhị phân
        W_NumBin(numBin, numText);
        System.out.println("Kich thuoc file van ban: ");
        SizeFileText(numText);
        System.out.println("Kich thuoc file nhi phan: ");
        SizeFileBin(numBin);
        System.out.println("File nhi phan: ");
        R_NumBin(numBin);
    }

}
