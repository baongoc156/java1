package uk.ac.york.minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MinesweeperFrame extends JFrame implements ActionListener
{
    // dộ khó
    private static final String[] DOKHO = { "Easy", "Medium", "Hard" };

    private static final String INCREMENT = "incr";
    private static final String RESET = "reset";

    // giao diện
    private JPanel mainPanel =  new JPanel(new BorderLayout(10, 10));
    private JComboBox<String> difficultyBox = new JComboBox<>(DOKHO);
    private MinefieldPanel minePanel;

    // Timer
    private Timer scoreTimer = new Timer(1000, this);
    private JLabel topTimer;
    private int time = 0;

    // Button Images
    private JButton topResetBtn;

    public MinesweeperFrame()
    {
        // đặt giao diện cơ bản
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        this.getContentPane().setBackground(Color.white);
        this.setSize(new Dimension(400, 500));
        this.setMinimumSize(new Dimension(400, 500));
        this.setTitle("Minesweeper");

        // khỏi tạo giao diện
        JPanel topPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        topPanel.setBackground(Color.WHITE);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        centerPanel.setBackground(Color.white);

        JPanel centerMidPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        minePanel = new MinefieldPanel(new Minefield(16, 16, 40));
        minePanel.addStateChangeListener((MinefieldStateChangeEvent e) -> {
            Minefield minefield = minePanel.getMinefield();
            
            if (minefield.isFinished())
            {
                // dừng hẹn giờ và đặ biểu tượng khuôn mặt
                scoreTimer.stop();
                
                if (minefield.getGameState() == GameState.WON)
                    topResetBtn.setIcon(new ImageIcon(Images.FACE_WON));
                else
                    topResetBtn.setIcon(new ImageIcon(Images.FACE_LOST));
            }
            else
            {
                // đặt khuông mặt bình thường nếu bắt đầu lại trò chơi
                topResetBtn.setIcon(new ImageIcon(Images.FACE_NORMAL));
                
                if (minefield.getGameState() == GameState.RUNNING)
                    scoreTimer.start();
            }
            
            topResetBtn.repaint();
        });

        centerMidPanel.add(minePanel);

        // chọn độ khó
        difficultyBox.setSelectedIndex(1);

        // nút reset
        topResetBtn = new JButton();
        topResetBtn.setPreferredSize(new Dimension(50, 50));
        topResetBtn.setActionCommand(RESET);
        topResetBtn.addActionListener(this);
        centerPanel.add(topResetBtn);

        topResetBtn.setIcon(new ImageIcon(Images.FACE_NORMAL));

        topTimer = new JLabel(String.valueOf(time) + " Seconds");
        scoreTimer.setActionCommand(INCREMENT);

        // thêm các mục toppanel
        topPanel.add(difficultyBox);
        topPanel.add(centerPanel);
        topPanel.add(topTimer);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerMidPanel, BorderLayout.CENTER);

        this.getContentPane().add(mainPanel, BorderLayout.NORTH);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals(INCREMENT))
        {
            time++;
        }
        else if(event.getActionCommand().equals(RESET))
        {
            // đặt lai bộ hẹn giờ
            scoreTimer.stop();
            time = 0;

            // đặt lại bãi mìn
            switch (difficultyBox.getSelectedIndex()) {
                case 0:
                    minePanel.setMinefield((new Minefield(9, 9, 10)));
                    break;
                case 2:
                    minePanel.setMinefield((new Minefield(30, 16, 99)));
                    break;
                case 1:
                    minePanel.setMinefield((new Minefield(16, 16, 40)));
                    break;
                default:
                    break;
            }

            pack();
        }

        topTimer.setText((time) + " Seconds   ");
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            new MinesweeperFrame().setVisible(true);
        });
    }
}
