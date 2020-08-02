/*
 *  Lop luu lai trang thai cua ban co
 */
package model;

public class BoardState {

    // Mang luu lai cac trang thai cac quan co
    public static int[][] boardArr;
    // chieu rong cua ban co
    public int width;
    // chieu cao cua ban co
    public int height;
    // khoi tao

    public BoardState(int width, int height) {
        boardArr = new int[width][height];
        this.height = height;
        this.width = width;
    }
    // reset ban co

    public int[][] resetBoard() {
        boardArr = new int[width][height];
        return boardArr;
    }

    // Check chien thang
    public int checkEnd(int row, int col) {
        int r = 0, c = 0;
        int j;
        boolean human, pc;
        // Check hang ngang
        for (; c < width - 4; c++) {
            human = true;
            pc = true;
            for (j = 0; j < 5; j++) {
                if (boardArr[row][c + j] != 1) {
                    human = false;
                }
                if (boardArr[row][c + j] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
        }
        // Check  hang doc
        while (r < height - 4) {
            human = true;
            pc = true;
            for (j = 0; j < 5; j++) {
                if (boardArr[r + j][col] != 1) {
                    human = false;
                }
                if (boardArr[r + j][col] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            r++;
        }

        // Check duong cheo xuong
        r = row;
        c = col;
        while (r > 0 && c > 0) {
            r--;
            c--;
        }
        while (r < height - 4 && c < width - 4) {
            human = true;
            pc = true;
            for (j = 0; j < 5; j++) {
                if (boardArr[r + j][c + j] != 1) {
                    human = false;
                }
                if (boardArr[r + j][c + j] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            r++;
            c++;
        }

        // Check duong cheo len
        r = row;
        c = col;
        while (r < height - 1 && c > 0) {
            r++;
            c--;
        }

        while (r >= 4 && c < height - 4) {
            human = true;
            pc = true;
            for (j = 0; j < 5; j++) {
                if (boardArr[r - j][c + j] != 1) {
                    human = false;
                }
                if (boardArr[r - j][c + j] != 2) {
                    pc = false;
                }
            }
            if (human) {
                return 1;
            }
            if (pc) {
                return 2;
            }
            r--;
            c++;
        }
        return 0;
    }

    // Lay trang thai cua quan co tai 1 toa do xac dinh
    public int getPosition(int x, int y) {
        return boardArr[x][y];
    }

    // set trang thai cho 1 quan co xac dinh
    public void setPosition(int x, int y, int player) {
        boardArr[x][y] = player;
    }
}