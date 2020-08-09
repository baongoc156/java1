
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class QLSVModel {

    private LinkedList<SinhVien> dssv;

    public LinkedList<SinhVien> getDssv() {
        return dssv;
    }

    public void setDssv(LinkedList<SinhVien> dssv) {
        this.dssv = dssv;
    }

    public QLSVModel() {
        dssv = new LinkedList<>();
    }
///thêm sinh viên
    public boolean Add(SinhVien sinhVien) {
        return dssv.add(sinhVien);
    }
///check trùng mã
    public boolean CheckTrungMa(QLSVModel ql, String maSV) {
        for (SinhVien monHoc : ql.getDssv()) {
            if (monHoc.getMaSV().equals(maSV)) {
                return true;
            }
        }
        return false;
    }
///Không hiểu . 
    public LinkedList<SinhVien> Find(String maSV) {
        LinkedList<SinhVien> dssv = new LinkedList<>();

        this.dssv.forEach((x) -> {
            boolean a = x.getMaSV().equals(maSV) ? dssv.add(x) : false;
        });

        return dssv;
    }
}
