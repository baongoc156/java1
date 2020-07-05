package chuong2_bai9;

public class TestPhanSo {

    public static void main(String[] args) {

        PhanSo ps1 = new PhanSo(3, 1);//tạo tử va mẫu cho phân số 1
        PhanSo ps2 = new PhanSo(1, 1);//tạo tử va mẫu cho phân số 2
        //in ra màn hình kết quả
        System.out.println("Tong hai phan so la: "+ps1.congPhanSo(ps2).toString());
        System.out.println("Tich hai phan so la: "+ps1.nhanPhanSo(ps2).toString());
        System.out.println("Thuong hai phan so la: "+ps1.chiaPhanSo(ps2).toString());
        System.out.println("Hieu hai phan so la: "+ps1.truPhanSo(ps2).toString());
        
        
        
    }
}
