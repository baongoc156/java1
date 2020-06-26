package bai2;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        QLSV q = new QLSV();
        try {
            ArrayList<SV> dssv = q.getAllSV();
            dssv.forEach(System.out::println);
            System.out.println("finish!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
