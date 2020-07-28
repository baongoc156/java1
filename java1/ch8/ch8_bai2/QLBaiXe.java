package ch8_bai2;

import java.util.LinkedList;

public class QLBaiXe {

    private LinkedList<Car> ListCar;

    public QLBaiXe() {
        ListCar = new LinkedList<>();
    }

    public LinkedList<Car> getListCar() {
        return ListCar;
    }

    public boolean AddCar(Car c) {
        return ListCar.add(c);
    }

    public double getTotalCost() {
        double total = 0;

        for (Car car : ListCar) {
            total += car.dongPhi();
        }
        
        return total;
    }

    public String PrintList(LinkedList<Car> cars) {
        StringBuilder sb = new StringBuilder();

        cars.forEach((oto) -> sb.append(oto).append("\n"));

        return sb.toString();
    }

    @Override
    public String toString() {
        return PrintList(ListCar);
    }

}
