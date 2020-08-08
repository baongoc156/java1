package uk.ac.york.minesweeper;

/*
 * trạng thái của bàn cờ
 */
public enum GameState
{
    /*
     * chưa bắt đầu chơi 
     */
    NOT_STARTED,

    /*
     * trờ chơi đang diển ra
     */
    RUNNING,

    /*
     * đã chiến thắng
     */
    WON,

    /*
     * đã thua
     */
    LOST,
}
