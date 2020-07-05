package chuong5_bai3_bai4;

public class test {

    public static void main(String[] args) throws Exception {
        QLSach qlsach = new QLSach();
        //in danh sach những cuốn sách theo mẫu
        qlsach.getBook();
        //Tăng giá sách có title='A Cup of Java'
        qlsach.tangGiaSach();
        //in danh sách sau khi thay doi 
        qlsach.getBook();
        //thay đổi số lượng sách có title='A Teaspoon of Java' 
        qlsach.thayDoiSL();
        //in lại danh sácch sau khi thay đổi
        qlsach.getBook();
        //chèn sách có id>6000
        qlsach.insert();
        qlsach.getBook();
        //xóa sách có id>6000
        qlsach.delete();
        qlsach.getBook();
        //chèn sách  (6001, 'Java ABC', 'Mr Author', 15.55, 55) và (8002, 'Java XYZ', 'Mr Author', 25.55, 55)
        qlsach.insert();
        qlsach.getBook();
    }
}
