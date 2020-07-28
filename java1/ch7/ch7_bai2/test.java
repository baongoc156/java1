package ch7_bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args) {
        ArrayList<Circle> l = new ArrayList<>();
        l.add(new Circle());
        l.add(new Circle());
        l.add(new Circle());
        l.add(new Circle());
        l.add(new Circle());
//        câu a
        l.forEach(System.out::println);
//        câu b
        System.out.println("");
        System.out.println("Medium: " + getMedium(l));
//        câu c
        System.out.println("");
        List l1 = l;
        Collections.sort(l1, (Circle c1, Circle c2) -> {
            if (c2.equals(c1)) {
                return 0;
            } else if (c2.getAcreage() > c1.getAcreage()) {
                return -1;
            } else {
                return 1;
            }
        });
        l.forEach(System.out::println);
//        câu d
        System.out.println("");
        l1 = l;
        Collections.sort(l1, (Circle c1, Circle c2) -> {
            if (c2.equals(c1)) {
                return 0;
            } else if (c2.getAcreage() < c1.getAcreage()) {
                return -1;
            } else {
                return 1;
            }
        });
        l.forEach(System.out::println);
//        câu e
        System.out.println("");
        System.out.println(l.get(min(l)));
//        câu f
        System.out.println("");
        System.out.println(l.get(max(l)));
    }

    public static double getMedium(ArrayList<Circle> l) {
        double result = 0;

        result = l.stream().map(Circle::getAcreage).reduce(result, (accumulator, _item) -> accumulator + _item);

        return result / l.size();
    }

    public static int min(ArrayList<Circle> l) {
        int min = l.get(0).getRadius();
        for (int i = 1; i < l.size(); i++) {
            if (min > l.get(i).getRadius()) {
                min = l.get(i).getRadius();
            }
        }
        return l.indexOf(new Circle(min));
    }

    public static int max(ArrayList<Circle> l) {
        int max = l.get(0).getRadius();
        for (int i = 1; i < l.size(); i++) {
            if (max < l.get(i).getRadius()) {
                max = l.get(i).getRadius();
            }
        }
        return l.indexOf(new Circle(max));
    }
}
