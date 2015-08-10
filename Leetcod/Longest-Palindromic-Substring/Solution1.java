public class Solution1 {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            int odd = helper (s, i - 1, i + 1);
            if (odd + 1 > end - start + 1) {
                start = i - odd / 2;
                end = i + odd / 2;
            } 
            int even = helper (s, i, i + 1);
            if (even > end - start + 1) {
                start = i + 1 - even / 2;
                end = i + even / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int helper (String s, int leftIndex, int rightIndex) {
        int rst = 0;
        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            rst = rst + 2;
            leftIndex--;
            rightIndex++;
        }
        return rst;
    }
}
