package chuong3_bai4;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException(String msg) {
        super(msg);
    }

    public IllegalTriangleException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
