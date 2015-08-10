public class Solution1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length();
        if(length1 + length2 != s3.length()) return false;
        boolean[][] matrix = new boolean[length1 + 1][length2 + 1];
        matrix[0][0] = true;
        for(int i = 1; i <= length1; i++) matrix[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        for(int j = 1; j <= length2; j++) matrix[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        for(int i = 1; i <= length1; i++) {
            for(int j = 1; j <= length2; j++) {
                boolean tmp1 = s1.charAt(i - 1) == s3.charAt(i + j - 1) && matrix[i - 1][j];
                boolean tmp2 = s2.charAt(j - 1) == s3.charAt(i + j - 1) && matrix[i][j - 1];
                matrix[i][j] = tmp1 || tmp2;
            }
        }
        return matrix[length1][length2];
    }
}
