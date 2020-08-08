package uk.ac.york.minesweeper;

import java.util.Arrays;
import java.util.Random;

/*
 * lớp chứa dữ liệu trò chơi dòng 23 dòng 129 ,152
 */
public class Minefield {

    // mảng chứ giá trị các ô bằng -1 là có mìn
    private final byte[][] valuesArray;

    // mảng chứa trạng thái các ô
    private final TileState[][] stateArray;

    // số lượng mìn
    private final int mines;

    // số ô cần mở để win
    private int tilesLeft;

    // If true, uncovers mines when the game finishes
    private boolean uncoverMinesAtEnd = true;

    // trạng thái trò chơi
    private GameState gameState = GameState.NOT_STARTED;

    /**
     * khởi tạo mảng mới với thuộc tính đã cho
     *
     * vị trí của mìn không được cấp phát cho đến khi nhấn ô đầu tiên
     *
     * @param width chiều rộng bãi mìn
     * @param height chiều cao bãi mìn
     * @param mines số mìn
     */
    public Minefield(int width, int height, int mines) {
        int tilesLeftTemp = (width * height) - mines;

        // kiểm tra bãi mìn
        if (width < 1 || height < 1 || mines < 0) {
            throw new IllegalArgumentException("Kích thước bãi mìn không hợp lệ");
        }

        if (tilesLeftTemp <= 0) {
            throw new IllegalArgumentException("Quá nhiều mìn");
        }

        // lưu lại
        this.mines = mines;
        this.tilesLeft = tilesLeftTemp;

        // khởi tạo mảng
        TileState[][] stateArrayTemp = new TileState[width][height];

        for (int x = 0; x < width; x++) {
            Arrays.fill(stateArrayTemp[x], TileState.COVERED);
        }

        this.stateArray = stateArrayTemp;
        this.valuesArray = new byte[width][height];
    }

    public int getWidth() {
        return valuesArray.length;
    }

    public int getHeight() {
        return valuesArray[0].length;
    }

    public int getMines() {
        return mines;
    }

    public boolean isUncoveringMinesAtEnd() {
        return uncoverMinesAtEnd;
    }

    public void setUncoverMinesAtEnd(boolean uncoverMinesAtEnd) {
        this.uncoverMinesAtEnd = uncoverMinesAtEnd;
    }

    public GameState getGameState() {
        return gameState;
    }

    /*
     * @return đúng nếu trò chơi kết thúc
     */
    public boolean isFinished() {
        return gameState != GameState.RUNNING && gameState != GameState.NOT_STARTED;
    }

    /**
     * lấy giá trị của vị trí đã cho
     *
     * chỉ được gọi khi ô đầu tiên được nhấp
     *
     * @param x vị trí x của ô
     * @param y vị trí y của ô
     * @return giá trị của ô hiện tại -1 = mìn
     */
    public int getTileValue(int x, int y) {
        if (gameState == GameState.NOT_STARTED) {
            throw new IllegalStateException("you must call uncover at least once before using getTileValue");
        }

        return valuesArray[x][y];
    }

    /**
     * lấy trạng thái của ô
     *
     * @param x vị trí x của ô
     * @param y vị trí y của ô
     * @return trạng thái của ô đó
     */
    public TileState getTileState(int x, int y) {
        return stateArray[x][y];
    }

    /**
     * cập nhật trạng thái của ô đã cho
     *
     * có thể dùng để thêm cờ và phát hiện ô. 
     * không thể mở ô đã được phát hiện
     * If a tile is uncovered, other tile states and the game state may be updated.
     *
     * @param x vị trí x của ô
     * @param y vị trí y của ô
     * @param newState trạng thái mới của ô
     */
    public void setTileState(int x, int y, TileState newState) {
        if (isFinished()) {
            throw new IllegalStateException("the game has finished");
        }

        switch (newState) {
            case COVERED:
            case FLAGGED:
            case QUESTION:
                // bắt ngoại lệ không thể mở ô đã mở
                if (stateArray[x][y] == TileState.UNCOVERED) {
                    throw new UnsupportedOperationException("không thể đổi ô đã mở ra");
                }
                stateArray[x][y] = newState;
                break;

            case UNCOVERED:
                // Forward to uncover
                uncover(x, y);
                break;

            default:
                throw new IllegalArgumentException("newState is not a valid tile state");
        }
    }

    /**
     * xem các ô xung quanh của vị trí đã cho
     *
     * @param x vị trí x của ô
     * @param y vị trí y của ô
     */
    public void uncover(int x, int y) {
        if (isFinished()) {
            throw new IllegalStateException("the game has finished");
        }

        // kiểm tra có phải game mới hay không
        if (gameState == GameState.NOT_STARTED) {
            initValues(x, y);
            gameState = GameState.RUNNING;
        }

        // thực hiện kiểm tra các ô xung quanh
        uncoverNoChecks(x, y);
    }

    /**
     * quy trình kiểm tra ô đã check 
     */
    private final SurroundingTilesProcessor PROCESSOR_UNCOVER = this::uncoverNoChecks;

    /**
     * kiểm tra ô xung quanh chưa được check
     * checks
     *
     * @param x vị trí x của ô
     * @param y vị trí y của ô
     */
    private void uncoverNoChecks(int x, int y) {
        int width = getWidth();
        int height = getHeight();

        // thoát ra nếu ô đã được phát hiện hoặc không tồn tại
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return;
        }

        if (stateArray[x][y] == TileState.UNCOVERED) {
            return;
        }

        // kiểm tra ô
        stateArray[x][y] = TileState.UNCOVERED;
        tilesLeft--;

        // kiểm tra ô đặt mìn
        if (valuesArray[x][y] == 0) {
            // xem tất cả các ô xung quanh
            processSurrounding(x, y, PROCESSOR_UNCOVER);
        } else if (valuesArray[x][y] < 0) {
            // trúng mìn
            gameState = GameState.LOST;
            uncoverAllMines();
        } else if (tilesLeft <= 0 && gameState == GameState.RUNNING) {
            //  xem tất cả các ô không phải mìn
            //  kiểm tra trạng thái trò chơi vì có thể trúng mìn và thắng
            gameState = GameState.WON;
            uncoverAllMines();
        }
    }

    /**
     * kiểm tra tất cả quả mìn nếu uncoverMintAtEnd được đặt
     *
     * kiểm tra số cờ đúng nhưng đặt sai
     * gắn cờ cho ô dấu chấm hỏi
     */
    private void uncoverAllMines() {
        if (uncoverMinesAtEnd) {
            int width = getWidth();
            int height = getHeight();

            // đặt trạng thải của tất cả các mìn để phát hiện
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (valuesArray[x][y] < 0) {
                        // đặt uncover nếu không có cờ
                        if (stateArray[x][y] != TileState.FLAGGED) {
                            stateArray[x][y] = TileState.UNCOVERED;
                        }
                    } else {
                        // đặt cờ nếu đó là câu hỏi
                        if (stateArray[x][y] == TileState.FLAGGED) {
                            stateArray[x][y] = TileState.QUESTION;
                        }
                    }
                }
            }
        }
    }

    /**
     * phát hiện các ô không được gắn cờ
     */
    private final SurroundingTilesProcessor PROCESSOR_CHORD = new SurroundingTilesProcessor() {
        @Override
        public void process(int x, int y) {
            // khám phá các ô không được gắn cờ
            if (stateArray[x][y] != TileState.FLAGGED) {
                uncoverNoChecks(x, y);
            }
        }
    };

    /**
     * xem tất cả các ô xung quanh
     *
     * tất cả các ô xung quanh hiện ra nếu số lượng các ô xung quanh bằng vị trí ô trung tâm
     * 
     *
     * This method does nothing if the central tile is still covered of the
     * number of surrounding flags in incorrect.
     *
     * @param x vị trí x của ô trung tâm 
     * @param y vị trí y của ô trung tâm 
     */
    public void chord(int x, int y) {
        if (isFinished()) {
            throw new IllegalStateException("trò chơi đã kết thúc");
        }

        // thoát khỏi hàm nếu ô không bị che
        if (stateArray[x][y] != TileState.UNCOVERED) {
            return;
        }

        // kiểm tra số cờ xung quanh
        if (valuesArray[x][y] == countSurroundingFlags(x, y)) {
            // khám phá các ô không được gắn cờ
            processSurrounding(x, y, PROCESSOR_CHORD);
        }
    }

    /**
     * tăng giá trị ô nếu nó k phải là ô có mìn
     */
    private final SurroundingTilesProcessor PROCESSOR_INIT_VALUES = new SurroundingTilesProcessor() {
        @Override
        public void process(int x, int y) {
            // giá trị tăng không phải là mìn
            if (valuesArray[x][y] >= 0) {
                valuesArray[x][y]++;
            }
        }
    };

    /**
     * khởi tạo giá trị cho trò chơi mới
     *
     * startX startY để ngăn mìn xuất hiện khi bắt đầu 
     *
     * @param startX vị trí x để ngăn chặn mìn
     * @param startY vị trí y để ngăn chặn mìn
     */
    private void initValues(int startX, int startY) {
        int width = getWidth();
        int height = getHeight();

        // đặt ngẩu nhiên cho mìn
        Random rnd = new Random();

        for (int i = 0; i < mines; i++) {
            int x, y;

            // đặt ngẩu nhiên cho đến khi có vị trí hợp lý
            do {
                x = rnd.nextInt(width);
                y = rnd.nextInt(height);
            } while (valuesArray[x][y] < 0 || (x == startX && y == startY));

            // đặt vị trí ngẩu nhiên làm mìn
            valuesArray[x][y] = -1;

            // tăng giá trị cho các ô xung quanh
            processSurrounding(x, y, PROCESSOR_INIT_VALUES);
        }
    }

    /**
     * đếm số cờ xung quanh 1 vị trí
     *
     * @param x vị trí x
     * @param y vị trí y
     * @return số lượng cờ xung quanh
     */
    private int countSurroundingFlags(int x, int y) {
        int count = 0;
        int width = getWidth();
        int height = getHeight();

        if (y > 0) {
            if (x > 0) {
                if (stateArray[x - 1][y - 1] == TileState.FLAGGED) {
                    count++;
                }
            }
            if (stateArray[x][y - 1] == TileState.FLAGGED) {
                count++;
            }
            if (x < width - 1) {
                if (stateArray[x + 1][y - 1] == TileState.FLAGGED) {
                    count++;
                }
            }
        }

        if (x > 0) {
            if (stateArray[x - 1][y] == TileState.FLAGGED) {
                count++;
            }
        }
        if (x < width - 1) {
            if (stateArray[x + 1][y] == TileState.FLAGGED) {
                count++;
            }
        }

        if (y < height - 1) {
            if (x > 0) {
                if (stateArray[x - 1][y + 1] == TileState.FLAGGED) {
                    count++;
                }
            }
            if (stateArray[x][y + 1] == TileState.FLAGGED) {
                count++;
            }
            if (x < width - 1) {
                if (stateArray[x + 1][y + 1] == TileState.FLAGGED) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * xử lý tất cả các ô xung quanh 
     *
     * @param x vị trí x của ô trung tâm
     * @param y vị trí y của ô trung tâm
     */
    private void processSurrounding(int x, int y, SurroundingTilesProcessor processor) {
        int width = getWidth();
        int height = getHeight();

        if (y > 0) {
            if (x > 0) {
                processor.process(x - 1, y - 1);
            }
            processor.process(x, y - 1);
            if (x < width - 1) {
                processor.process(x + 1, y - 1);
            }
        }

        if (x > 0) {
            processor.process(x - 1, y);
        }
        if (x < width - 1) {
            processor.process(x + 1, y);
        }

        if (y < height - 1) {
            if (x > 0) {
                processor.process(x - 1, y + 1);
            }
            processor.process(x, y + 1);
            if (x < width - 1) {
                processor.process(x + 1, y + 1);
            }
        }
    }

    /**
     * hiển thị bãi mìn qua string
     *
     * @return
     */
    @Override
    public String toString() {
        int width = getWidth();
        int height = getHeight();

        StringBuilder builder = new StringBuilder();

        // dòng trên cùng
        builder.append('+');
        for (int x = 0; x < width; x++) {
            builder.append('-');
        }
        builder.append("+\n");

        // từng dòng trong bãi mìn
        for (int y = 0; y < height; y++) {
            builder.append('|');

            for (int x = 0; x < width; x++) {
                char c;

                // xữ lý trạng thái của ô
                switch (getTileState(x, y)) {
                    case COVERED:
                        c = '#';
                        break;

                    case FLAGGED:
                        c = 'f';
                        break;

                    case QUESTION:
                        c = '?';
                        break;

                    default:
                        // hiển thị gía trị của ô
                        int tileValue = getTileValue(x, y);

                        if (tileValue < 0) {
                            c = '!';
                        } else if (tileValue == 0) {
                            c = ' ';
                        } else {
                            c = (char) ('0' + tileValue);
                        }
                }

                builder.append(c);
            }

            builder.append("|\n");
        }

        // dòng dưới cùng
        builder.append('+');
        for (int x = 0; x < width; x++) {
            builder.append('-');
        }
        builder.append("+\n");

        return builder.toString();
    }

    /**
     * interface xử lý các ô xung quanh
     */
    private interface SurroundingTilesProcessor {

        /**
         * xử lý ô đã cho
         *
         * @param x vị trí x
         * @param y vị trí y
         */
        public void process(int x, int y);
    }
}
