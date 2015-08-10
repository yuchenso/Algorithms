public class Solution1 {
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        if (length == 0) return true;
        boolean[][][] matrix = new boolean[length][length][length];
        
        for (int i = 0; i < length; i++) {
            for (int m = 0; m < length; m++) {
                matrix[i][i][m] = s1.charAt(i) == s2.charAt(m);
            }
        }
        
        for (int jStart = 1; jStart < length; jStart++) {
            for (int j = jStart, i = 0; j < length; i++, j++) {
                for (int m = 0; m + j - i < length; m++) {
                    for (int t = i; t <= j; t++) {
                        boolean part1 = matrix[t][i][m] && matrix[j][t + 1][m + t - i + 1];
                        boolean part2 = matrix[t][i][m + j - t] && matrix[j][t + 1][m];
                        matrix[j][i][m] = part1 || part2;
                        if (matrix[j][i][m]) break;
                    }
                }
            }
        }
        
        return matrix[length - 1][0][0];
    }
}
