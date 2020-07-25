package QLSinhVien;

import java.util.LinkedList;

public class QLMonHocModel {

    private LinkedList<MonHoc> monHocs;

    public LinkedList<MonHoc> getMonHocs() {
        return monHocs;
    }

    public void setMonHocs(LinkedList<MonHoc> monHocs) {
        this.monHocs = monHocs;
    }

    public QLMonHocModel() {
        monHocs = new LinkedList<>();
    }

    public boolean AddMonHoc(MonHoc monHoc) {
        return monHocs.add(monHoc);
    }

    public boolean CheckTrungMa(QLMonHocModel ql, String maMonHoc) {
        for (MonHoc monHoc : ql.getMonHocs()) {
            if (monHoc.getMaMonHoc().equals(maMonHoc)) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<MonHoc> Find(String maMH) {
        LinkedList<MonHoc> mhs = new LinkedList<>();

        monHocs.forEach((x) -> {
            boolean a = x.getMaMonHoc().equals(maMH) ? mhs.add(x) : false;
        });
        
        return mhs;
    }

    @Override
    public String toString() {
        return "QLMonHocModel{" + "monHocs=" + monHocs + '}';
    }
}
