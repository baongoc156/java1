package chuong4_bai3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class R_W_File {

    public static void W_File(String filePath) {
        Random rd = new Random();
        File ktra = new File(filePath);

        //Kiểm tra file đã tồn tại chưa
        if (ktra.exists() == false) {
            System.out.println("File khong ton tai\nTạo file: " + ktra.getPath());
        }

        //Tạo file và ghi 20 số nguyên ngẫu nhiên
        try {
            FileWriter fw = new FileWriter(ktra);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 10; i++) {
                int rand = rd.nextInt(100);
                bw.write(String.format("%d ", rand));
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
        }
    }

    //đọc file
    public static void R_File(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
        }

    }

}
