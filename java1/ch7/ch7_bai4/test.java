package ch7_bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args) {
        Poker p = new Poker();
        System.out.println(p);

        List l = p.getBoBai();
        Collections.shuffle(l);
        p.setBoBai((ArrayList<String>) l);

        System.out.println(p);

        List strs = p.getBoBai();

        Collections.sort(strs, (String o1, String o2) -> Poker.getValue(o1) - Poker.getValue(o2));

        System.out.println(p);
    }
}
