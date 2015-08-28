public class Solution {
    public int numIslands(char[][] grid) {
        int rst = 0;
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[j][i] == '1') {
                    rst++;
                    bfsTraverse(grid, j, i);
                }
            }
        }
        return rst;
    }
    
    private void bfsTraverse(char[][] grid, int j, int i) {
        int m = grid.length;
        int n = grid[0].length;
        Stack<Integer> jStack = new Stack<Integer>();
        Stack<Integer> iStack = new Stack<Integer>();
        jStack.push(j);
        iStack.push(i);
        while (!jStack.isEmpty()) {
            int curJ = jStack.pop();
            int curI = iStack.pop();
            grid[curJ][curI] = '#';
            if (curI - 1 >= 0 && grid[curJ][curI - 1] == '1') {
                jStack.push(curJ);
                iStack.push(curI - 1);
            }
            if (curI + 1 < n && grid[curJ][curI + 1] == '1') {
                jStack.push(curJ);
                iStack.push(curI + 1);                
            }
            if (curJ - 1 >= 0 && grid[curJ - 1][curI] == '1') {
                jStack.push(curJ - 1);
                iStack.push(curI);                 
            }
            if (curJ + 1 < m && grid[curJ + 1][curI] == '1') {
                jStack.push(curJ + 1);
                iStack.push(curI);                 
            }
        }
    }
}
