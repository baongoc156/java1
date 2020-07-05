package chuong3_bai4;

public class Triangle {

    public Triangle(int a, int b, int c) throws IllegalTriangleException {
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalTriangleException("loi dau vao tong 2 canh lon hon canh con lai");
        }
    }
}
