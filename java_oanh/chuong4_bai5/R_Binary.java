package chuong4_bai5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class R_Binary {

    //Tạo 10 số nguyên ngẫu nhiên 
    public static void W_NumText(String file) {
        Random rd = new Random();
        try {
            try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
                for (int i = 0; i < 10; i++) {
                    int rand = rd.nextInt(100);
                    bw.write(String.format("%d ", rand));
                }
                bw.close();
                fw.close();
            }
        } catch (IOException e) {
        }
    }

    //Ghi file nhị phân
    public static void W_NumBin(String numBin, String file) {
        try {
            FileOutputStream fos = new FileOutputStream(numBin);
            DataOutputStream dos = new DataOutputStream(fos);
            //Ghi số nguyên vào file nhị phân
            for (int i : Read(file)) {
                dos.writeInt(i);
            }
            dos.close();
            fos.close();

        } catch (IOException e) {
        }
    }

    //hiển thị kích thước file văn bản
    public static void SizeFileText(String numFile) {
        File f = new File(numFile);
        System.out.println(f.length());
    }

    //hiển thị kích thước file nhị phân
    public static void SizeFileBin(String numBin) {
        File f = new File(numBin);
        System.out.println(f.length());
    }

    //đọc file nhị phân
    public static void R_NumBin(String numBin) {
        try {
            FileInputStream fis = new FileInputStream(numBin);
            DataInputStream dis = new DataInputStream(fis);
            int c;

            while ((c = dis.readInt()) >= 0 && c < 100) {
                System.out.print(c + " ");
            }
            fis.close();
        } catch (IOException ex) {

        }
    }
    //Lấy mảng số nguyên từ file text

    public static int[] Read(String filePath) {
        int[] arr = new int[10];
        BufferedReader br;
        try (FileReader fr = new FileReader(filePath)) {
            br = new BufferedReader(fr);

            String line = br.readLine();
            String[] lines = new String[10];
            int j = 0;
            for (int i = 0; i < lines.length; i++) {
                lines[i] = new String();
                for (; line.charAt(j) != ' ' && j < line.length() - 1; j++) {
                    lines[i] += line.charAt(j);
                }
                j++;
            }
            lines[lines.length - 1] += line.charAt(line.length() - 1);

            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(lines[i].trim());
            }

            return arr;
        } catch (IOException ioe) {
            System.out.println("loi doc file");
        }
        return arr;
    }
}
