package caro;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PlayNow extends Thread {

    private JPanel user;

    public PlayNow(JPanel user) {
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            user.setBorder(new LineBorder(Color.yellow));
            try {
                Thread.sleep(500);
                user.setBorder(new LineBorder(Color.green));
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
