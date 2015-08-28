public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result += (n >> i) & 1;
        }
        return result;
    }
}
