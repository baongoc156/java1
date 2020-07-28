package flappybird1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private ConChim conchimT = new ConChim();
    private Ong ongnuoc1 = new Ong(1000 + 280 * 0);
    private Ong ongnuoc2 = new Ong(1000 + 280 * 1);
    private Ong ongnuoc3 = new Ong(1000 + 280 * 2);
    private Ong ongnuoc4 = new Ong(1000 + 280 * 3);
    // private KiemTra kiemtraT = new KiemTra();

    private static int diem = 0;

    private static boolean bl1 = false;
    private static boolean bl2 = false;
    private static boolean bl3 = false;
    private static boolean bl4 = false;

    private static boolean ketThuc = false;

    private Thread threadT;

    public GamePanel() {
        threadT = new Thread(this);
        threadT.start(); // khi goi lenh nay se duoc chuyen den phuong thuc
        // run() phia duoi
    }

    // ve cac nhan vat trong game
    @Override
    public void paint(Graphics g) {

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight());

        // them ong nuoc vao nen game
        ongnuoc1.paint(g);
        ongnuoc2.paint(g);
        ongnuoc3.paint(g);
        ongnuoc4.paint(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0, 400, getWidth(), getHeight());

        // them con chim vao game
        conchimT.paint(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 20));
        g.drawString("diem: " + diem, 10, 20);
    }

    // implements Runnable thư viện để chạy game
    @Override
    public void run() {

        // 1 vong lap khong bao gio dung
        while (true) {

            repaint(); // goi lai paint

            ongnuoc1.giamX(); // goi den phuong thuc giamX cua class OngNuoc
            ongnuoc2.giamX();
            ongnuoc3.giamX();
            ongnuoc4.giamX();

            try {
                Thread.sleep(15); // chuong trinh dung lai 20 ms
            } catch (InterruptedException e) {
            }

            ongnuoc1.laplaiX(); // goi den phuong thuc .... cua class OngNuoc
            ongnuoc2.laplaiX();
            ongnuoc3.laplaiX();
            ongnuoc4.laplaiX();

            conchimT.tangY(); // con chim tu roi xuong dat chet

            
//            if (arg0.getKeyCode() == KeyEvent.VK_I) {
//                if (arg0.getKeyCode() == KeyEvent.VK_E) {
//                    if (arg0.getKeyCode() == KeyEvent.VK_N) {
//
//                    }
//                }
//            }

            // kiem tra dieu kien neu chet thi dung game
            if (chet() == true) {
                ketThuc = true;
                threadT.stop();
            }

            quaOngTangDiem(conchimT, ongnuoc1);
            quaOngTangDiem(conchimT, ongnuoc2);
            quaOngTangDiem(conchimT, ongnuoc3);
            quaOngTangDiem(conchimT, ongnuoc4);

        }

    }

    public boolean chet() {

        // khi con chim cham dat
        if (conchimT.getY() + ConChim.kichThuoc >= 400) {
            return true;
        }
        // khi con chim cham ong nuoc
        // con chim cham ong nuoc thu 1234

        return coVaCham(conchimT, ongnuoc1) || coVaCham(conchimT, ongnuoc2)
                || coVaCham(conchimT, ongnuoc3) || coVaCham(conchimT, ongnuoc4);
    }

    private boolean coVaCham(ConChim chim, Ong ong) {
        boolean c = (chim.getX() + ConChim.kichThuoc) >= ong.getX();//chui vô lỗ
        boolean d = chim.getY() <= ong.getH();//nằm giữa lỗ
        boolean a = (d && c && chim.getX() <= (ong.getX() + Ong.PI));

        boolean b = chim.getY() + ConChim.kichThuoc >= ong.getH() + Ong.TRONG
                && (((chim.getX() + ConChim.kichThuoc) >= ong.getX()))
                && chim.getX() <= (ong.getX() + Ong.PI);

        return a || b;
    }

    private void quaOngTangDiem(ConChim chim, Ong ong) {
        if (chim.getX() + ConChim.kichThuoc > ong.getX() && chim.getX() < ong.getX() + 65) {
            ong.setChuaQua(true);
        }
        if (ong.isChuaQua() == true && chim.getX() > ong.getX() + 65) {
            diem++;
            ong.setChuaQua(false);
        }
    }
}
