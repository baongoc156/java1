package ch8_bai1;

import java.util.LinkedList;

public class QLXe {

    private LinkedList<Oto> ListOto;

    public LinkedList<Oto> getListOto() {
        return ListOto;
    }

    public void setListOto(LinkedList<Oto> ListOto) {
        this.ListOto = ListOto;
    }

    public QLXe() {
        ListOto = new LinkedList<>();
    }

    public boolean AddCar(Oto oto) {
        return ListOto.add(oto);
    }

    public LinkedList<Oto> getTonnageBigger(double tonnage) {
        LinkedList<Oto> otos = new LinkedList<>();

        ListOto.forEach((x) -> {
            boolean a = (x.getTrongTai() > tonnage) ? (otos.add(x)) : false;
        });

        return otos;
    }

    public LinkedList<Oto> getBrand(String brand) {
        LinkedList<Oto> otos = new LinkedList<>();

        ListOto.forEach((x) -> {
            boolean a = (x.getNhanHieu().equals(brand)) ? (otos.add(x)) : false;
        });

        return otos;
    }

    public String PrintList(LinkedList<Oto> otos) {
        StringBuilder sb = new StringBuilder();

        otos.forEach((oto) -> sb.append(oto).append("\n"));

        return sb.toString();
    }

    @Override
    public String toString() {
        return PrintList(ListOto);
    }
}
