
package chuong3_bai3;


public class Calculator {
    public int div(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Loi chia cho 0");
        } else {
            return a / b;
        }
    }
}
