package ch8_bai2;

public class test {
    public static void main(String[] args) {
        QLBaiXe ql = new QLBaiXe();
        
        ql.AddCar(new Oto("Kia", "123", "do", 30));//120000
        ql.AddCar(new Bus("10", "1234", "xanh", 20));//20000
        ql.AddCar(new Oto("audi", "121", "vang", 40));//160000
        ql.AddCar(new Bus("Kia", "123", "do", 30));//30000
        ql.AddCar(new Oto("Kia", "123", "do", 10));//50000
        
        System.out.println(ql.getTotalCost());
    }
}
