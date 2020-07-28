package flappybird1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ong {

    public static int caoMax = 400;
    public static int rongMax = 1000;
    public static int PI = 65;
    public static int TRONG = 100;// khoang trong giua 2 ong nuoc
    private int x;//what the hell

    private static boolean sieuNangLuc = false;

    public static boolean isSieuNangLuc() {
        return sieuNangLuc;
    }

    public static void setSieuNangLuc(boolean sieuNangLuc) {
        Ong.sieuNangLuc = sieuNangLuc;
    }

    private int h;

    private boolean chuaQua = false;

    public Ong() {
        ngaunhien();
    }

    public Ong(int x) {
        ngaunhien();
        this.x = x;
    }

    

    public int getX() {
        if (sieuNangLuc) {
            return 0;
        }
        return x;
    }

    public int getH() {
        if (sieuNangLuc) {
            return 0;
        }
        return h;
    }

    public boolean isChuaQua() {
        return chuaQua;
    }

    public void setChuaQua(boolean chuaQua) {
        this.chuaQua = chuaQua;
    }

    // chieu dai ngau nhien cua 1 ong nuoc
    public void ngaunhien() {
        Random rd = new Random();

        h = 100 + rd.nextInt(200); // h1 se bang 1 so ngau nhien trong khoang 0
        // - 199

    }

    // ve ong nuoc
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, 0, PI, h);

        g.fillRect(x, h + TRONG, PI, caoMax - h - TRONG);
        g.setColor(Color.black);

        g.drawLine(x, 0, x, h);
        g.drawLine(x, h, PI + x, h);
        g.drawLine(x + PI, 0, PI + x, h);

        g.drawLine(x, h + TRONG, x, caoMax);
        g.drawLine(x, h + TRONG, x + PI, h + TRONG);
        g.drawLine(x + PI, h + TRONG, x + PI, caoMax);
    }

    // ong nuoc di chuyen giam theo chieu X
    public void giamX() {
        x -= 2;
    }

    // ong nuoc lap lai theo chieu X
    public void laplaiX() {
        if (x == -PI - 1) {
            x = rongMax;
        }
    }
}
