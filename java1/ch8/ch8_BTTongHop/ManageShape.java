package ch8_BTTongHop;

import java.util.Collections;
import java.util.LinkedList;

public class ManageShape {

    private LinkedList<Shape> listShape;

    public ManageShape(LinkedList<Shape> listShape) {
        this.listShape = listShape;
    }

    public ManageShape() {
        listShape = new LinkedList<>();
    }

    public LinkedList<Shape> getListShape() {
        return listShape;
    }

    public void setListShape(LinkedList<Shape> listShape) {
        this.listShape = listShape;
    }

    public boolean add(Shape a) {
        try {
            listShape.add(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int demSoHCN() {
        int count = 0;

        count = listShape.stream()
                .filter((shape) -> (shape instanceof Rectagle))
                .map((_item) -> 1)
                .reduce(count, Integer::sum);

        return count;
    }

    public LinkedList<Shape> sort() {
        LinkedList<Shape> list = (LinkedList<Shape>) listShape.clone();

        Collections.sort(list, (Shape x, Shape y) -> (int) (x.calculateArea() - y.calculateArea()));
        
        return list;
    }

    public LinkedList<Shape> getHCN() {
        LinkedList<Shape> hcn = new LinkedList<>();

        listShape.stream()
                .filter((shape) -> (shape instanceof Rectagle))
                .forEachOrdered((shape) -> {
                    hcn.add(shape);
                });

        return hcn;

    }

    public LinkedList<Shape> getHCNMaxArea() {
        LinkedList<Shape> HCNs = getHCN();
        LinkedList<Shape> hcn = new LinkedList<>();

        double max = getMaxArea();

        HCNs.stream().filter((s) -> (s.calculateArea() == max)).forEachOrdered((shape) -> {
            hcn.add(shape);
        });

        return hcn;
    }

    public double getMaxArea() {
        LinkedList<Shape> HCNs = getHCN();

        double max = HCNs.getFirst().calculateArea();

        for (int i = 0; i < HCNs.size() - 1; i++) {
            if (HCNs.get(i).calculateArea() < HCNs.get(i + 1).calculateArea()) {
                max = HCNs.get(i + 1).calculateArea();
            }
        }

        return max;
    }
}
