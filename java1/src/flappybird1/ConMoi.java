package flappybird1;

import java.awt.Graphics;
import java.awt.Color;

public class ConMoi {
    public static int size = 5;
    private static int y = -5;
    private static int x = -5;
    
    public static void xuatHien(Ong ongNuoc1){
        x = ongNuoc1.getX() + 32;
        y = ongNuoc1.getH() + 32;
    }
    
    public static int getY() {
        return y;
    }

    public static int getX() {
        return x;
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
    }

    public ConMoi() {
    }
    
}
