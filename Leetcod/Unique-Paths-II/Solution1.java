public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] matrix = new int[m + 1][n + 1];
		matrix[1][0] = 1;
		for(int i = 1; i <= m; i++){
		    for(int j = 1; j <= n; j++){ 
		        matrix[i][j] = obstacleGrid[i - 1][j - 1] == 1? 0 : matrix[i - 1][j] + matrix[i][j - 1];
		    }
		}
		
		return matrix[m][n];
    }
}
