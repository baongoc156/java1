package chuong4_bai4;

import static chuong4_bai4.ReplaceText.ReadOldString;
import static chuong4_bai4.ReplaceText.Replace;

public class TestReplace {

    public static void main(String[] args) {
        String file = "D:\\LuuThiKieuOanh_CD19TT9\\Java\\BaiTap\\Cacchuong\\src\\chuong4_bai4\\sourceFile.txt";
        String destFile = "destFile.txt";
        ReadOldString(file);
        Replace(file, destFile);
    }
}
