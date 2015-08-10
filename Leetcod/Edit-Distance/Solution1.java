public class Solution1 {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length(), length2 = word2.length();
        int[][] matrix = new int[length1 + 1][length2 + 1];
        for(int i = 0; i <= length1; i++) matrix[i][0] = i;
        for(int j = 0; j <= length2; j++) matrix[0][j] = j;
        for(int i = 1; i <= length1; i++) {
            for(int j = 1; j <= length2; j++) {
                int replace = word1.charAt(i - 1) == word2.charAt(j - 1)? matrix[i - 1][j - 1] : matrix[i - 1][j - 1] + 1;
                int delete = matrix[i - 1][j] + 1;
                int insert = matrix[i][j - 1] + 1;
                matrix[i][j] = Math.min(replace, Math.min(delete, insert));
            }
        }
        return matrix[length1][length2];
    }
}
