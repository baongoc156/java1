package testCaro;

public class Coltroler {

    static int maxXY = 10;
    static int values[][] = new int[maxXY][maxXY];
    static int BOM = 20, dem = 0;

    public static void main(String[] args) {
        for (int i = 0; i < maxXY; i++) {
            for (int j = 0; j < maxXY; j++) {
                System.out.print(values[i][j] + "\t");
            }
            System.out.println("");
        }
//        initBom();
    }

    static void initBom() {
        float ratio = (float) 0.05; // Tỉ lệ tạo mìn những ô xung quanh
        int i, j;
//        for (i = 0; i <= maxXY + 1; i++) {
//            for (j = 0; j <= maxXY + 1; j++) {
//                values[i][j] = 0;
//            }
//        }
        while (dem < BOM) {
            // Chọn ra tạo độ chưa phải là mìn.
            do {
                i = (int) ((maxXY - 1) * Math.random()) + 1;
                j = (int) ((maxXY - 2) * Math.random()) + 1;
            } while (values[i][j] != 0);
            if (values[i][j] == 0) {
                init(i, j, ratio);
            }
        }
    }

    static void init(int i, int j, float ratio) {
        if (Math.random() < ratio) {
            values[i][j] = -1;
            for (int k = i - 1; k <= i + 1; k++) {
                for (int h = j - 1; h <= j + 1; h++) {
                    if (values[k][h] != -1) {
                        values[k][h]++;
                    }
                }
            }
            dem++;
            //Gọi hàm tạo bom cho những ô xung quanh.
            for (int k = i - 1; k <= i + 1; k++) {
                for (int h = j - 1; h <= j + 1; h++) {
                    if (k > 0 && h > 0 && values[k][h] != -1 && dem < BOM) {
                        init(k, h, ratio);
                    }
                }
            }
        }
    }
}
