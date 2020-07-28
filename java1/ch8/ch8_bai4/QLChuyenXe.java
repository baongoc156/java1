package ch8_bai4;

import java.util.LinkedList;

public class QLChuyenXe {

    private LinkedList<ChuyenXe> chuyenXes;

    public LinkedList<ChuyenXe> getChuyenXes() {
        return chuyenXes;
    }

    public void setChuyenXes(LinkedList<ChuyenXe> chuyenXes) {
        this.chuyenXes = chuyenXes;
    }

    public QLChuyenXe() {
        chuyenXes = new LinkedList<>();
    }

    public boolean AddChuyenXe(ChuyenXe cx) {
        return chuyenXes.add(cx);
    }

    public LinkedList<ChuyenXe> FindMaxRevenue() {
        double max = getMaxRevenue();
        LinkedList<ChuyenXe> cxs = new LinkedList<>();

        chuyenXes.forEach((x) -> {
            boolean a = x.getDoanhThu() == max ? cxs.add(x) : false;
        });

        return cxs;
    }

    public double getMaxRevenue() {
        double max = chuyenXes.get(0).getDoanhThu();

        for (int i = 1; i < chuyenXes.size() - 1; i++) {
            if (chuyenXes.get(i).getDoanhThu() > max) {
                max = chuyenXes.get(i).getDoanhThu();
            }
        }

        return max;
    }

    public double getSumRevenue(ChuyenXe cx) {
        double revenue = 0;

        if (cx instanceof ChuyenXeNgoaiThanh) {
            for (ChuyenXe chuyenXe : chuyenXes) {
                if (chuyenXe instanceof ChuyenXeNgoaiThanh) {
                    revenue += chuyenXe.getDoanhThu();
                }
            }
        } else {
            for (ChuyenXe chuyenXe : chuyenXes) {
                if (chuyenXe instanceof ChuyenXeNoiThanh) {
                    revenue += chuyenXe.getDoanhThu();
                }
            }
        }

        return revenue;
    }

    public double getSumBonus(ChuyenXe cx) {
        double bonus = 0;

        if (cx instanceof ChuyenXeNgoaiThanh) {
            for (ChuyenXe chuyenXe : chuyenXes) {
                if (chuyenXe instanceof ChuyenXeNgoaiThanh) {
                    bonus += chuyenXe.TinhThuong();
                }
            }
        } else {
            for (ChuyenXe chuyenXe : chuyenXes) {
                if (chuyenXe instanceof ChuyenXeNoiThanh) {
                    bonus += chuyenXe.TinhThuong();
                }
            }
        }

        return bonus;
    }

    @Override
    public String toString() {
        return "QLChuyenXe{" + "chuyenXes=" + chuyenXes + '}';
    }
}
