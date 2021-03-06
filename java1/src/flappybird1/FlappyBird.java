package flappybird1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JFrame;

public class FlappyBird extends JFrame {

    private GamePanel gamePanel = new GamePanel();
    private ConChim conchimM = new ConChim();
    int i = 0;

    public FlappyBird() {
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        setResizable(false);
        add(gamePanel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent arg0) {

//                if (arg0.getKeyCode() == KeyEvent.VK_T) {
//                    Ong.setSieuNangLuc(true);
//                }
//
//                if (arg0.getKeyCode() == KeyEvent.VK_O) {
//                    Ong.setSieuNangLuc(false);
//                }
                if (conchimM.getY() >= 0) {
                    conchimM.giamY();
                }
                if (GamePanel.ketThuc==true) {
                    GamePanel.ketThuc = false;
                }
            }
        });
    }

    public static void main(String[] arg) {
        FlappyBird mh = new FlappyBird();
    }
}
