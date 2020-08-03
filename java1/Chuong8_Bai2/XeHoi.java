package Chuong8_Bai2;

public class XeHoi extends Xe {

    private String hangXe;

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public XeHoi() {
    }

    public XeHoi(String hangXe, String bienSo, String mauXe, int soChoNgoi) {
        super(bienSo, mauXe, soChoNgoi);
        this.hangXe = hangXe;
    }

    @Override
    public double dongPhi() {
        return getSoChoNgoi() >= 30 ? getSoChoNgoi() * 5000 * 0.8 : getSoChoNgoi() * 5000;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s%s%n", "Hang xe:", getHangXe()));
        sb.append(String.format("%-20s%s%n", "Bien so:", getBienSo()));
        sb.append(String.format("%-20s%s%n", "Mau xe:", getMauXe()));
        sb.append(String.format("%-20s%s%n", "So cho ngoi:", getSoChoNgoi()));
        sb.append(String.format("%-20s%s%n", "Phi:", dongPhi()));

        return sb.toString();
    }

}
