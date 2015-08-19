public class Solution {
    public int titleToNumber(String s) {
        int rst = 0;
        for (int i = 0; i < s.length(); i++) {
            rst = rst * 26 + (s.charAt(i) - 'A' + 1);
        }
        return rst;
    }
}
