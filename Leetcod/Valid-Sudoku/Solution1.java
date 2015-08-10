public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        for (int j = 0; j < 9; j++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int i = 0; i < 9; i++) {
                if (board[j][i] == '.') continue;
                if (!(board[j][i] >= '1' && board[j][i] <= '9') || set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (!(board[j][i] >= '1' && board[j][i] <= '9') || set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        for (int iStart = 0; iStart < 9; iStart = iStart + 3) {
            for (int jStart = 0; jStart < 9; jStart = jStart + 3) {
                HashSet<Character> set = new HashSet<Character>();
                for (int i = iStart; i < iStart + 3; i++) {
                    for (int j = jStart; j < jStart + 3; j++) {
                        if (board[j][i] == '.') continue;
                        if (!(board[j][i] >= '1' && board[j][i] <= '9') || set.contains(board[j][i])) return false;
                        set.add(board[j][i]);
                    }
                }
            }
        }
        return true;
    }
}
