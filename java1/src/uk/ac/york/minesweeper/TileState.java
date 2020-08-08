package uk.ac.york.minesweeper;

/*
 * tình trạng hiện tại của 1 ô mìn
 */
public enum TileState
{
    /*
     * default không có cờ hay k biết
     */
    COVERED,

    /*
     * trên ô là cờ
     */
    FLAGGED,

    /*
     * trên ô là không biết
     */
    QUESTION,

    /*
     * đã được chọn
     */
    UNCOVERED,
}
