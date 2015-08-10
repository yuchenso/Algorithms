public class Solution1 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int start, int i, int j) {
        if (start == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) return false;
        board[i][j] = '#';
        boolean rst = helper(board, word, start + 1, i + 1, j) || helper(board, word, start + 1, i - 1, j) || helper(board, word, start + 1, i, j + 1) || helper(board, word, start + 1, i, j - 1);
        board[i][j] = word.charAt(start);
        return rst;
    }
}
