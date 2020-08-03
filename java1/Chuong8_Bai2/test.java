package Chuong8_Bai2;

public class test {
    public static void main(String[] args) {
        QLBaiXe ql = new QLBaiXe();
        
        ql.AddCar(new XeHoi("Kia", "123", "do", 30));
        ql.AddCar(new XeBuyt("10", "1234", "xanh", 20));
        ql.AddCar(new XeHoi("audi", "121", "vang", 40));
        ql.AddCar(new XeBuyt("Kia", "123", "do", 30));
        ql.AddCar(new XeHoi("Kia", "123", "do", 10));
        
        System.out.println(ql.getTotalCost());
    }
}
