package chuong4_bai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        String file = "D:\\LuuThiKieuOanh_CD19TT9\\Java\\BaiTap\\Cacchuong\\src\\chuong4_bai1\\bai1.txt";
        try {
            BufferedReader br;
            try (FileReader fr = new FileReader(file)) {
                br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            br.close();
        } catch (IOException ex) {
            System.out.println("Loi doc file: " + ex);
        }
    }

}
