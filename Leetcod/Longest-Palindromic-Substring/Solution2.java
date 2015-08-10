/**
 * Time: O(n^2)
 * Space: O(n^2)
 * Tags: Palindrome; DP;
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        int maxGap = 0, maxi = 0, maxj = 0;
        boolean[][] matrix = new boolean[s.length()][s.length()];
        for(int j = 0; j < s.length(); j++) matrix[j][j] = true;
        for(int j = 1, i = 0; j < s.length(); j++, i++) {
            matrix[j][i] = s.charAt(i) == s.charAt(j);
            if(matrix[j][i] && maxGap < 1) {
                maxGap = 1;
                maxi = i;
                maxj = j;
            }
        }
        for(int gap = 2; gap < s.length(); gap++){
            for(int j = gap, i = 0; j < s.length(); j++, i++){
                matrix[j][i] = (s.charAt(i) == s.charAt(j)) && matrix[j - 1][i + 1];
                if(matrix[j][i] && maxGap < gap){
                    maxGap = gap;
                    maxi = i;
                    maxj = j;
                }
            }
        }
        return s.substring(maxi, maxj + 1);
    }
}
