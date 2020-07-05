package chuong2_bai9;

public class PhanSo {

    private int tuSo;
    private int mauSo;

    public PhanSo() {
    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }
    //Tìm ước chung lớn nhất của tử và mẫu

    public int UCLN(int tuSo, int mauSo) {
        while (tuSo != mauSo) {
            if (tuSo > mauSo) {
                tuSo = tuSo - mauSo;
            } else {
                mauSo = mauSo - tuSo;
            }
        }
        return tuSo;
    }
    //Tối giản phân số

    public PhanSo toiGian() {
        int temp = UCLN(this.getTuSo(), this.getMauSo());
        this.setTuSo(this.getTuSo() / temp);
        this.setMauSo(this.getMauSo() / temp);
        PhanSo pS = new PhanSo(this.tuSo, this.mauSo);
        return pS;
    }
    //Cộng 2 phân số

    public PhanSo congPhanSo(PhanSo pSKhac) {
        int tSo = this.getTuSo() * pSKhac.getMauSo() + this.getMauSo() * pSKhac.getTuSo();
        int mSo = this.getMauSo() * pSKhac.getMauSo();
        PhanSo pS = new PhanSo(tSo, mSo);

        return pS.toiGian();
    }
    //Trừ 2 phân số

    public PhanSo truPhanSo(PhanSo pSKhac) {

        int tSo = this.getTuSo() * pSKhac.getMauSo() - this.getMauSo() * pSKhac.getTuSo();
        int mSo = this.getMauSo() * pSKhac.getMauSo();
        PhanSo pS = new PhanSo(tSo, mSo);

        if (pS.tuSo == 0) {
            return pS;
        } else {
            return pS.toiGian();
        }
    }
    //nhân 2 phân số

    public PhanSo nhanPhanSo(PhanSo pSKhac) {
        int tSo = this.getTuSo() * pSKhac.getTuSo();
        int mSo = this.getMauSo() * pSKhac.getMauSo();
        PhanSo pS = new PhanSo(tSo, mSo);
        return pS.toiGian();
    }

    //chia 2 phân số
    public PhanSo chiaPhanSo(PhanSo pSKhac) {
        int tSo = this.getTuSo() * pSKhac.getMauSo();
        int mSo = this.getMauSo() * pSKhac.getTuSo();
        PhanSo pS = new PhanSo(tSo, mSo);
        return pS.toiGian();
    }

    @Override
    public String toString() {
        if (mauSo == 1) {
            return tuSo + "";
        } else if (tuSo == 0) {
            return "0";
        } else {
            return tuSo + "/" + mauSo;
        }
    }

}
