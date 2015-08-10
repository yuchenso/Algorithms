public class Solution1 {
    public void solveSudoku(char[][] board) {
        char[][] resultBoard = new char[9][9];
        resultBuilder(resultBoard ,board, 0, 0);
        boardCopy(board, resultBoard);
    }
    
    private void resultBuilder(char[][] resultBoard, char[][] board, int iStart, int jStart) {
        if (jStart == 9) {
            boardCopy(resultBoard, board);
            return;
        }
        
        if (board[jStart][iStart] != '.') {
            if (iStart == 8) {
                resultBuilder(resultBoard, board, 0, jStart + 1);    
            }
            else {
                resultBuilder(resultBoard, board, iStart + 1, jStart);
            }
        }
        else {
            for (char value = '1'; value <= '9'; value++) {
                if (isValid(board, iStart, jStart, value)) {
                    board[jStart][iStart] = value;
                    if (iStart == 8) {
                        resultBuilder(resultBoard, board, 0, jStart + 1);    
                    }
                    else {
                        resultBuilder(resultBoard, board, iStart + 1, jStart);
                    }
                    board[jStart][iStart] = '.';
                }
            }
        }
    }
    
    /**
     * Judge whether the value at board[j][i] is a valid one.
     */
    private boolean isValid(char[][] board, int i, int j, char value) {
        for (int m = 0; m < 9; m++) {
            if (board[j][m] == value || board[m][i] == value) return false; 
        }
        
        for (int m = (j / 3) * 3; m < (j / 3) * 3 + 3; m++) {
            for (int n = (i / 3) * 3; n < (i / 3) * 3 + 3; n++) {
                if (board[m][n] == value) return false;
            }
        }
        return true;
    }
    
    private void boardCopy(char[][] board1, char[][] board2) {
        for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               board1[j][i] = board2[j][i];
           }
        }
    }
}
