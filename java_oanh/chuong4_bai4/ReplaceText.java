package chuong4_bai4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReplaceText {

    public static void ReadOldString(String file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
        }
    }

    public static void Replace(String file, String destFile) {
        try {
            Scanner newInput = new Scanner(System.in);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(destFile);
            BufferedWriter bw = new BufferedWriter(fw);
            String oldString;
            int i = 0;
            while ((oldString = br.readLine()) != null) {
                System.out.println("Nhap vao chuoi moi cho dòng " + ++i + " :");
                String newString = newInput.nextLine();
                bw.write(newString + "\n");
            }
            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (IOException e) {
        }
    }

}
