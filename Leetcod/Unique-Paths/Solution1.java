public class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m + 1][n + 1];
        matrix[1][0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m][n];
    }
}
