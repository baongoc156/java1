package ch8_BTTongHop;

public class test {

    public static void main(String[] args) {
        ManageShape ms = new ManageShape();

        ms.add(new Rectagle(0, 0, 3, 4));
        ms.add(new Rectagle(0, 0, 1, 4));
        ms.add(new Rectagle(0, 0, 2, 4));

        System.out.println(ms.getListShape().get(0).calculateArea());
        System.out.println(ms.getListShape().get(1).calculateArea());
        System.out.println(ms.getListShape().get(2).calculateArea());

        
    }
}
