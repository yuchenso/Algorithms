public class Solution1 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return; 
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfsTraverse(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                bfsTraverse(board, m - 1, i);
            }
        }
        
        for (int j = 1; j < m - 1; j++) {
            if (board[j][0] == 'O') {
                bfsTraverse(board, j, 0);
            }
            if (board[j][n - 1] == 'O') {
                bfsTraverse(board, j, n - 1);
            }
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (board[j][i] == 'O') {
                    board[j][i] = 'X';
                }
                else if (board[j][i] == '#') {
                    board[j][i] = 'O';
                }
            }
        }
    }
    
    private void bfsTraverse(char[][] board, int j, int i) {
        int m = board.length;
        int n = board[0].length;
        Stack<Integer> jStack = new Stack<Integer>();
        Stack<Integer> iStack = new Stack<Integer>();
        jStack.push(j);
        iStack.push(i);
        while(!jStack.isEmpty()) {
            int curJ = jStack.pop();
            int curI = iStack.pop();
            board[curJ][curI] = '#';
            if (curI - 1 >= 0 && board[curJ][curI - 1] == 'O') {
                jStack.push(curJ);
                iStack.push(curI - 1);
            }
            if (curI + 1 < n && board[curJ][curI + 1] == 'O') {
                jStack.push(curJ);
                iStack.push(curI + 1);
            }
            if (curJ + 1 < m && board[curJ + 1][curI] == 'O') {
                jStack.push(curJ + 1);
                iStack.push(curI);
            }  
            if (curJ - 1 >= 0 && board[curJ - 1][curI] == 'O') {
                jStack.push(curJ - 1);
                iStack.push(curI);
            }  
        }
    }
}
