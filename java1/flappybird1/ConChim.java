package flappybird1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ConChim {

    public static int kichThuoc = 25;
    private static int y = 150;
    private static int x = 300;

    //lay ra gia tri y
    public static int getY() {
        return y;
    }

    //lay ra gia tri x
    public static int getX() {
        return x;
    }

    //ve con chim
    public void paint(Graphics g) {
        try {
            BufferedImage bird = ImageIO.read(new File(".\\res\\Bird.png"));
            g.drawImage(bird, x - 5, y - 5, kichThuoc + 10, kichThuoc + 10, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //con chim roi xuong dat
    public int tangY() {
        if (GamePanel.ketThuc) {
            y = 150;
            x = 300;
        }
        return y += 2;

    }

    //con chim bay len troi
    public int giamY() {
        return y -= 35;
    }
}
