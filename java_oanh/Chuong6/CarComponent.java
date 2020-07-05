/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuong6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class CarComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Mycar car1 = new Mycar(0, 0);
//        int x = getWidth() - 60;
//        int y = getHeight() - 30;
//        Mycar car2 = new Mycar(x, y);
        car1.draw(g2);
//        car2.draw(g2);

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarComponent ca = new CarComponent();
        frame.add(ca);
        frame.setVisible(true);

    }
}
