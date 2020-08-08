package uk.ac.york.minesweeper;

/**
 * sự kiện kích hoạt khi trạng thái trò chơi thay đổi 
 */
public interface MinefieldStateChangeListener
{
    /**
     * được gọi khi trạng thái trò chơi của bãi mìn thay đổi 
     *
     * @param event
     */
    public void stateChanged(MinefieldStateChangeEvent event);
}
