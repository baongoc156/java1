package uk.ac.york.minesweeper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/*
 * lớp static chứa các hình ảnh trò chơi
 */
public final class Images
{
    // thư mục chứa file hình ảnh 
    private static final String RES_DIRECTORY = "/res/";

    // ảnh trái mìn 
    public static final BufferedImage MINE = loadImageResource("mine.png");

    // ảnh cờ 
    public static final BufferedImage FLAG = loadImageResource("flag.png");

    //hình khuôn mặt bình thường
    public static final BufferedImage FACE_NORMAL = loadImageResource("default.png");

    //hình khuông mặt khi chiến thắng
    public static final BufferedImage FACE_WON = loadImageResource("won.png");

    //hình khuôn mặt khi thua
    public static final BufferedImage FACE_LOST = loadImageResource("lost.png");

    /*
     * Loads an image from the resources directory
     *
     * @param name file path
     * @return hình ảnh đã tải
     */
    private static BufferedImage loadImageResource(String name)
    {
        // khởi tạo luồng
        try (InputStream imgStream = Images.class.getResourceAsStream(RES_DIRECTORY + name))
        {
            // đọc file hình ảnh từ luồng
            return ImageIO.read(imgStream);
        }
        catch (IOException e)
        {
            // lỗi tải ảnh
            throw new RuntimeException("lỗi tải ảnh: " + name, e);
        }
    }

    private Images()
    {
    }
}
