package ch8_bai2;

abstract class Car {
    private String bienSo;
    private String mauXe;
    private int soChoNgoi;

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public Car() {
    }

    public Car(String bienSo, String mauXe, int soChoNgoi) {
        this.bienSo = bienSo;
        this.mauXe = mauXe;
        this.soChoNgoi = soChoNgoi;
    }

    public abstract double dongPhi();
}
