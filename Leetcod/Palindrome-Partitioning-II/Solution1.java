public class Solution1 {
    public int minCut(String s) {
        boolean[][] matrix = buildMatrix(s);
        int[] array = new int[s.length()];
        for(int j = 0; j < s.length(); j++) {
            if(matrix[j][0] == true) {
                array[j] = 0;
            }
            else {
                array[j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    if(matrix[j][j - k + 1] == true) array[j] = Math.min(array[j], array[j - k] + 1);
                }
            }
        }
        return array[s.length() - 1];
    }
    
    private boolean[][] buildMatrix(String s) {
        int n = s.length();
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) matrix[i][i] = true;
        for (int i = 0, j = 1; j < n; i++, j++) {
            matrix[j][i] = s.charAt(i) == s.charAt(j);
        }
        for(int jStart = 2; jStart < n; jStart++) {
            for(int i = 0, j = jStart; j < n; i++, j++) {
                matrix[j][i] = matrix[j - 1][i + 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        return matrix;
    }
}
