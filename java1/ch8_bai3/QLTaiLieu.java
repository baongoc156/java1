package ch8_bai3;

import java.util.LinkedList;

public class QLTaiLieu {

    private LinkedList<TaiLieu> taiLieus;

    public LinkedList<TaiLieu> getTaiLieus() {
        return taiLieus;
    }

    public void setTaiLieus(LinkedList<TaiLieu> TaiLieus) {
        this.taiLieus = TaiLieus;
    }

    public QLTaiLieu() {
        taiLieus = new LinkedList<>();
    }

    public boolean add(TaiLieu t) {
        return taiLieus.add(t);
    }

    public LinkedList<TaiLieu> timSach() {
        LinkedList<TaiLieu> tls = new LinkedList<>();

        taiLieus.forEach((x) -> {
            if (x instanceof Sach) {
                tls.addLast(x);
            }
        });

        return tls;
    }

    public LinkedList<TaiLieu> timBao() {
        LinkedList<TaiLieu> tls = new LinkedList<>();

        taiLieus.forEach((x) -> {
            if (x instanceof Bao) {
                tls.addLast(x);
            }
        });

        return tls;
    }

    public LinkedList<TaiLieu> timTapChi() {
        LinkedList<TaiLieu> tls = new LinkedList<>();

        taiLieus.forEach((x) -> {
            if (x instanceof TapChi) {
                tls.addLast(x);
            }
        });

        return tls;
    }

    public double tinhTongTienTheoLoai(TaiLieu t) {
        LinkedList<TaiLieu> tls;
        double tongTien = 0;
        if (t instanceof Sach) {
            tls = timSach();
            tls.forEach((x) -> count(tongTien, x.getPrice()));
        } else if (t instanceof Bao) {
            tls = timBao();
            tls.forEach((x) -> count(tongTien, x.getPrice()));
        } else {
            tls = timTapChi();
            tls.forEach((x) -> count(tongTien, x.getPrice()));
        }
        return tongTien;
    }

    public void count(double x, double y) {
        x += y;
    }
    
    public LinkedList<TaiLieu> timTheoTenGanDung(String ten){
        LinkedList<TaiLieu> tls = new LinkedList<>();
        
        taiLieus.forEach((x)->{
            if (x.getTenTaiLieu().contains(ten)) {
                tls.add(x);
            }
        });
     
        return tls;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        taiLieus.forEach((x) -> sb.append(x));

        return sb.toString();
    }

}
