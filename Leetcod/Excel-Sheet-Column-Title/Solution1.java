public class Solution {
    public String convertToTitle(int n) {
        String rst = "";
        while (n != 0) {
            n--;
            rst = (char)('A' + n % 26) + rst; 
            n = n / 26;
        }
        return rst;
    }
}
