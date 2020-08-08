package uk.ac.york.minesweeper;

import java.util.EventObject;

/**
 * bắt sự kiện khi bãi mìn thay đổi trạng thái
 */
public class MinefieldStateChangeEvent extends EventObject
{
    /**
     * khởi tạo đối tượng
     *
     * @param source
     */
    public MinefieldStateChangeEvent(Object source)
    {
        super(source);
    }
}
