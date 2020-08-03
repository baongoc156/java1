package Chuong8_Bai2;

import java.util.LinkedList;

public class QLBaiXe {

    private LinkedList<Xe> dsx;

    public QLBaiXe() {
        dsx = new LinkedList<>();
    }

    public LinkedList<Xe> getListCar() {
        return dsx;
    }

    public boolean AddCar(Xe c) {
        return dsx.add(c);
    }

    public double getTotalCost() {
        double total = 0;

        for (Xe car : dsx) {
            total += car.dongPhi();
        }

        return total;
    }

    public String inDSXe(LinkedList<Xe> dsx) {
        String s = "";
        s = dsx.stream().map((xe) -> xe.toString()).reduce(s, String::concat);

        return s;
    }

    @Override
    public String toString() {
        return inDSXe(dsx);
    }

}
