public class Solution1 {
    public int numDistinct(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if(sLength < tLength) return 0;
        int[][] matrix = new int[tLength + 1][sLength + 1];
        for (int i = 0; i <= sLength; i++) matrix[0][i] = 1;
        for (int j = 1; j <= tLength; j++) matrix[j][0] = 0;
        for (int j = 1; j <= tLength; j++) {
            for (int i = 1; i <= sLength; i++) {
                if (s.charAt(i - 1) != t.charAt(j - 1) && i > j) matrix[j][i] = matrix[j][i - 1];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    if(i == j) matrix[j][i] = matrix[j - 1][i - 1];
                    if(i > j) matrix[j][i] = matrix[j - 1][i - 1] + matrix[j][i - 1];
                }
            }
        }
        return matrix[tLength][sLength];
    }
}
