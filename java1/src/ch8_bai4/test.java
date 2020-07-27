package ch8_bai4;

public class test {

    public static void main(String[] args) {
        QLChuyenXe ql = new QLChuyenXe();

        ql.AddChuyenXe(new ChuyenXeNgoaiThanh("tphcm", 2, "123", "tien", "123", 100000));
        ql.AddChuyenXe(new ChuyenXeNgoaiThanh("tphcm", 2, "123", "tien", "123", 200000));
        ql.AddChuyenXe(new ChuyenXeNgoaiThanh("tphcm", 2, "123", "tien", "123", 400000));
        ql.AddChuyenXe(new ChuyenXeNoiThanh("123", 50, "123", "tien", "123", 100000));
        ql.AddChuyenXe(new ChuyenXeNoiThanh("123", 50, "123", "tien", "123", 200000));
        ql.AddChuyenXe(new ChuyenXeNoiThanh("123", 50, "123", "tien", "123", 300000));

        System.out.println(ql.getSumRevenue(new ChuyenXeNoiThanh()));
    }
}
