public class Solution1 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] matrix = new int[m][n];
        matrix[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            matrix[0][i] = matrix[0][i - 1] + grid[0][i];
        }
        for(int j = 1; j < m; j++) {
            matrix[j][0] = matrix[j - 1][0] + grid[j][0];
        }
        for(int j = 1; j < m; j++){
            for(int i = 1; i < n; i++) {
                matrix[j][i] = Math.min(matrix[j - 1][i], matrix[j][i - 1]) + grid[j][i];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
