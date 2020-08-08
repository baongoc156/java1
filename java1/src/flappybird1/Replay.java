package flappybird1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Replay {

    public static int size = 30;
    private static int y = 150;
    private static int x = 150;

    public static int getY() {
        return y;
    }

    public static int getX() {
        return x;
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 20));
        g.drawString("Nhấn nút bất kỳ để chơi lại", 380, 200);
    }

}
