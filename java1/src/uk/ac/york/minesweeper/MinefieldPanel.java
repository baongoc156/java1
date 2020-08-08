package uk.ac.york.minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * thành phần hiển thị bãi mìn bằng đồ hoạ và xử lý các sự kiện
 */
public class MinefieldPanel extends JComponent {

    //kích thước của tất cả ô 
    private static final int TILE_SIZE = 32;

    // độ dài của góc xiên
    private static final int BEVEL_WIDTH = 2;

    // cỡ font chữ
    private static final int FONT_VOFFSET = 24;

    // font chữ 
    private static final Font FONT = new Font(Font.MONOSPACED, Font.BOLD, 24);

    // nền mặt định 
    private static final Color COLOUR_BACKGROUND = new Color(0xC0, 0xC0, 0xC0);

    // màu xám cho góc xiên 
    private static final Color COLOUR_LIGHT = new Color(0xE0, 0xE0, 0xE0);

    // màu xám đậm cho góc xiên 
    private static final Color COLOUR_DARK = new Color(0x80, 0x80, 0x80);

    // màu của đấu chấm hỏi 
    private static final Color COLOUR_QUESTION = Color.WHITE;

    // màu của số (0 không được sử dụng) 
    private static final Color[] COLOUR_NUMBERS = new Color[]{
        null, // 0 = Unused
        new Color(0x00, 0x00, 0xFF), // 1 = Blue
        new Color(0x00, 0x7F, 0x00), // 2 = Green
        new Color(0xFF, 0x00, 0x00), // 3 = Red
        new Color(0x2F, 0x2F, 0x9F), // 4 = Dark Blue
        new Color(0x7F, 0x00, 0x00), // 5 = Maroon
        new Color(0x9F, 0x9F, 0x2F), // 6 = Turquoise
        new Color(0x00, 0x00, 0x00), // 7 = Black
        new Color(0x7F, 0x7F, 0x7F), // 8 = Grey
    };

    // bãi mìn hiên tại 
    private Minefield minefield;

    // ô hiện tại được chọn
    private Point selectedTile;

    // List of state change listeners 
    private ArrayList<MinefieldStateChangeListener> listeners = new ArrayList<>();

    /**
     * khởi tạo panel mới với bãi mìn đã cho
     *
     * luôn phải có 1 bãi mìn hiển thị
     *
     * @param minefield bãi mìn để hiển thị
     */
    public MinefieldPanel(Minefield minefield) {
        this.addMouseListener(new MouseEventListener());
        this.setBackground(COLOUR_BACKGROUND);
        this.setOpaque(true);
        this.setFont(FONT);
        this.setMinefield(minefield);
    }

    /**
     * thêm trình lắng nghe
     *
     * @param listener trình lắng nghe để thêm
     */
    public void addStateChangeListener(MinefieldStateChangeListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * xoá trình lắng nghe
     *
     * @param listener trình lắng nghe để xoá
     */
    public void removeStateChangeListener(MinefieldStateChangeListener listener) {
        listeners.remove(listener);
    }

    /**
     * kích hoạt sự kiện
     */
    private void fireStateChangeEvent() {
        MinefieldStateChangeEvent event = new MinefieldStateChangeEvent(this);

        for (MinefieldStateChangeListener listener : listeners) {
            listener.stateChanged(event);
        }
    }

    /**
     * @return bãi mìn hiện tại
     */
    public Minefield getMinefield() {
        return minefield;
    }

    /**
     * đặt bãi mìn mới cho panel
     *
     * @param newMinefield bãi mìn mới
     */
    public void setMinefield(Minefield newMinefield) {
        if (newMinefield == null) {
            throw new IllegalArgumentException("newMinefield cannot be null");
        }

        this.minefield = newMinefield;

        // đặt lại ô đã chọn thành null
        this.selectedTile = null;

        // cập nhật hình ảnh
        this.setSize(getPreferredSize());
        //vẽ lại panel
        this.repaint();

        // kích hoạt sự kiện
        this.fireStateChangeEvent();
    }

    /**
     * vẽ ký tự trên ô
     *
     * @param g
     * @param x vị trí x trên cùng bên trái của ô
     * @param y vị trí y trên cùng bên trái của ô
     * @param c ký tự để vẽ
     */
    private static void drawCharacter(Graphics g, int x, int y, char c) {
        // nhận toạ độ để vẽ
        int drawX = x + (TILE_SIZE - g.getFontMetrics().charWidth(c)) / 2;
        int drawY = y + FONT_VOFFSET;

        // vẽ ký tự
        g.drawChars(new char[]{c}, 0, 1, drawX, drawY);
    }

    /**
     * vẽ hình ảnh tại vị trí ô đã cho
     *
     * @param g
     * @param x vị trí x trên cùng bên trái của ô
     * @param y vị trí y trên cùng bên trái của ô
     * @param img ảnh để vẽ
     */
    private static void drawImage(Graphics g, int tileX, int tileY, BufferedImage img) {
        int xOff = tileX + (TILE_SIZE - img.getWidth()) / 2;
        int yOff = tileY + (TILE_SIZE - img.getHeight()) / 2;

        g.drawImage(img, xOff, yOff, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // nhận vị trí ô đã chọn
        int selectedX = (selectedTile == null ? -1 : selectedTile.x);
        int selectedY = (selectedTile == null ? -1 : selectedTile.y);

        // làm cho các con số đẹp gơn chút
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // vẽ nền
        if (isOpaque()) {
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        // vẽ tất cả các ô
        for (int x = 0; x < minefield.getWidth(); x++) {
            for (int y = 0; y < minefield.getHeight(); y++) {
                int graphicsX1 = x * TILE_SIZE;
                int graphicsY1 = y * TILE_SIZE;

                // vẽ nền cho ô
                g2d.setColor(COLOUR_DARK);
                g2d.drawLine(graphicsX1, graphicsY1, graphicsX1 + TILE_SIZE, graphicsY1);
                g2d.drawLine(graphicsX1, graphicsY1, graphicsX1, graphicsY1 + TILE_SIZE);

                // đã được chọn hoặc chưa
                if (minefield.getTileState(x, y) == TileState.UNCOVERED) {
                    // vẽ ký hiệu
                    int tileValue = minefield.getTileValue(x, y);

                    if (tileValue < 0) {
                        drawImage(g2d, graphicsX1, graphicsY1, Images.MINE);
                    } else if (tileValue > 0) {
                        g2d.setColor(COLOUR_NUMBERS[tileValue]);
                        drawCharacter(g2d, graphicsX1, graphicsY1, (char) ('0' + tileValue));
                    }
                } else {
                    // vẽ nền xiên nếu đây k phải là ô đã chọn 
                    if (x != selectedX || y != selectedY) {
                        int bevelX2 = graphicsX1 + TILE_SIZE - BEVEL_WIDTH;
                        int bevelY2 = graphicsY1 + TILE_SIZE - BEVEL_WIDTH;

                        g2d.setColor(COLOUR_LIGHT);
                        g2d.fillRect(graphicsX1, graphicsY1, TILE_SIZE, BEVEL_WIDTH);
                        g2d.fillRect(graphicsX1, graphicsY1, BEVEL_WIDTH, TILE_SIZE);
                        g2d.setColor(COLOUR_DARK);
                        g2d.fillRect(graphicsX1, bevelY2, TILE_SIZE, BEVEL_WIDTH);
                        g2d.fillRect(bevelX2, graphicsY1, BEVEL_WIDTH, TILE_SIZE);
                    }

                    // vẽ cờ hoặc dấu chấm hỏi nếu 
                    if (minefield.getTileState(x, y) == TileState.FLAGGED) {
                        drawImage(g2d, graphicsX1, graphicsY1, Images.FLAG);
                    } else if (minefield.getTileState(x, y) == TileState.QUESTION) {
                        g2d.setColor(COLOUR_QUESTION);
                        drawCharacter(g2d, graphicsX1, graphicsY1, '?');
                    }
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(TILE_SIZE * minefield.getWidth(),
                TILE_SIZE * minefield.getHeight());
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    /**
     * xử lý sự kiện chuột trong khu vực chơi
     */
    private class MouseEventListener extends MouseAdapter {

        /**
         * tính ô đã chọn từ 1 sự kiện chuột
         */
        private Point getTileFromEvent(MouseEvent e) {
            return new Point(e.getX() / TILE_SIZE, e.getY() / TILE_SIZE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // xoá ô đã chọn
            if (selectedTile != null) {
                selectedTile = null;
                repaint();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // bỏ qua nếu đã xong
            if (minefield.isFinished()) {
                return;
            }

            // lấy vị trí ô 
            Point tile = getTileFromEvent(e);

            // nhấp chuột phải hay trái?
            if (SwingUtilities.isLeftMouseButton(e)) {
                // không chọn ô có cờ ở trên
                if (minefield.getTileState(tile.x, tile.y) == TileState.FLAGGED) {
                    return;
                }

                // lấy vi trí thành vị trí đã chọn
                selectedTile = tile;
            } else if (SwingUtilities.isRightMouseButton(e)) {
                TileState newState;

                // thay đổi trạng thái gắn cờ
                switch (minefield.getTileState(tile.x, tile.y)) {
                    case COVERED:
                        newState = TileState.FLAGGED;
                        break;
                    case FLAGGED:
                        newState = TileState.QUESTION;
                        break;
                    default:
                        newState = TileState.COVERED;
                        break;
                    case UNCOVERED:
                        newState = TileState.UNCOVERED;
                        break;
                }

                minefield.setTileState(tile.x, tile.y, newState);
            }

            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // bỏ qua nếu hoàn thành
            if (minefield.isFinished()) {
                return;
            }

            // đảm bảo ô hiện tại đang chọn không pahri là null
            if (selectedTile != null) {
                // đảm bảo ô được chọn giống ô được nhấp vào
                if (selectedTile.equals(getTileFromEvent(e))) {
                    // kiểm tra số lần nhấp
                    GameState state = minefield.getGameState();

                    if (e.getClickCount() == 2) {
                        minefield.chord(selectedTile.x, selectedTile.y);
                    } else if (e.getClickCount() == 1) {
                        minefield.uncover(selectedTile.x, selectedTile.y);
                    }

                    // sự kiện thay đổi trạng thái nếu cần
                    if (minefield.getGameState() != state) {
                        fireStateChangeEvent();
                    }
                }

                // xoá ô được chọn
                selectedTile = null;
                repaint();
            }
        }
    }
}
