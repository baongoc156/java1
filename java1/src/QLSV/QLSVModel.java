package QLSV;

import java.util.LinkedList;

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

    public boolean add(SinhVien sinhVien) {
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
///Không hiểu

    public LinkedList<SinhVien> Find(String maSV) {
        LinkedList<SinhVien> dssvTemp = new LinkedList<>();

        for (SinhVien sinhVien : getDssv()) {
            System.out.println(sinhVien.getMaSV());
            if (sinhVien.getMaSV().equals(maSV)) {
                dssvTemp.add(sinhVien);
            }
        }

        return dssvTemp;
    }
}
