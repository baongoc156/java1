package bai2_ch5;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        QLSV qsv = new QLSV();
        QLUser qu = new QLUser();

        try {
//            ArrayList<SV> dssv = q.getAllSV();
//            dssv.forEach(System.out::println);
            user u = new user("baobaote", "chooanh");
            if (qu.logIn(u)) {
                System.out.println("dang nhap thanh cong!");
            }else{
                System.out.println("dang nhap that bai!");
            }
            System.out.println("finish!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
