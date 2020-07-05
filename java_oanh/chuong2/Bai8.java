package chuong2;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Bai8 {

    public static void main(String[] args) {

        //Tạo hai số ngẫu nhiên
        Random random = new Random();
        int num1 = random.nextInt(11);
        int num2 = random.nextInt(11);

        //Tạo mảng chuỗi thông báo đúng và sai
        String[] right = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
        String[] wrong = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "Wrong. Keep trying."};

        //create a frame ("Tạo frame")
        JFrame frame = new JFrame();

        // show a joptionpane dialog using showMessageDialog (Hiển thị hộp thoại dùng showMessageDialog)
        JOptionPane.showMessageDialog(frame, "Welcome babies to us !");
        String str = String.format("%d + %d = ", num1, num2);//Chuỗi gồm 2 số hiển thị trên màn hình
        //cho người dùng nhập vào dùng showInput... và đọc kết quả dùng int...parseInt....
        int result = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Result: ", str, JOptionPane.PLAIN_MESSAGE));

        //dùng câu lệnh điều kiện if else để xét kết quả
        //hiển thị thông báo đúng sai
        if (result == (num1 + num2)) {
            JOptionPane.showMessageDialog(frame, right[random.nextInt(4)], "Result: ", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, wrong[random.nextInt(4)], "Result: ", JOptionPane.WARNING_MESSAGE);
        }
        System.exit(0);

    }

}
