package chuong2_bai10;

public class TestDiem {
    
    public static void main(String[] args) {
        
        Diem diem=new Diem(4,0);
        Diem diemKhac=new Diem(0,2);
        System.out.println(diem.tinhKhoangCachToiO());
        System.out.println(diem.tinhKhoangCachToiDiemKhac(diemKhac));
    }
}
