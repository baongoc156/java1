package bai2;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        QLSV q = new QLSV();
        try {
//            ArrayList<SV> dssv = q.getAllSV();
//            dssv.forEach(System.out::println);
            SV sv = new SV("4", "nguyen", "baobaote00@gmail.com");
            q.updateInStudenID(sv,"3");
            System.out.println("finish!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
