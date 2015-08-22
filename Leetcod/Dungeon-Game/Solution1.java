public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length, N = dungeon[0].length;
        int[][] matrix = new int[M][N];
        matrix[0][0] = dungeon[M - 1][N - 1] * (-1);
        
        for (int i = 1; i < N; i++) {
            matrix[0][i] = Math.max(matrix[0][i - 1] + dungeon[M - 1][N - 1 - i] * (-1), dungeon[M - 1][N - 1 - i] * (-1));
        }
        for (int j = 1; j < M; j++) {
            matrix[j][0] = Math.max(matrix[j - 1][0] + dungeon[M - 1 - j][N - 1] * (-1), dungeon[M - 1 - j][N - 1] * (-1));
        }
        
        for (int j = 1; j < M; j++) {
            for (int i = 1; i < N; i++) {
                int part1 = Math.max(matrix[j][i - 1] + dungeon[M - 1 - j][N - 1 - i] * (-1), dungeon[M - 1 - j][N - 1 - i] * (-1));
                int part2 = Math.max(matrix[j - 1][i] + dungeon[M - 1 - j][N - 1 - i] * (-1), dungeon[M - 1 - j][N - 1 - i] * (-1));
                matrix[j][i] = Math.min(part1, part2);
            }
        }
        return matrix[M - 1][N - 1] <= 0? 1 : matrix[M - 1][N - 1] + 1;
    }
}
