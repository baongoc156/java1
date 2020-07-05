package chuong2_bai11;

public class TestHCN {

    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat(2, 3, 4, 5);
        HinhChuNhat hcn1 = new HinhChuNhat(7, 2, 3, 7);
        Diem khac = new Diem(2, 1);
        if (hcn.kiemTraDiemThuoc(khac) == 1) {
            System.out.println("Diem(" + khac.getX() + "," + khac.getY() + ") " + "thuoc " + "Hinh Chu Nhat" + "(" + hcn.toString() + ")");
        } else {
            System.out.println("Diem(" + khac.getX() + "," + khac.getY() + ") " + "khong thuoc " + "Hinh Chu Nhat" + "(" + hcn.toString() + ")");
        }

        if (hcn.kiemTraHinhChuNhat(hcn1) == 1 || hcn1.kiemTraHinhChuNhat(hcn) == 1) {
            System.out.println("Hinh Chu Nhat (" + hcn.toString() + ")" + "va " + "Hinh Chu Nhat (" + hcn1.toString() + ")" + "giao nhau");
        } else {
            System.out.println("Hinh Chu Nhat (" + hcn.toString() + ")" + "va " + "Hinh Chu Nhat (" + hcn1.toString() + ")" + " khong giao nhau");
        }

    }

}
