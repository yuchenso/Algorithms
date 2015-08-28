public class Solution {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result = (result << 1) + ((n >> i) & 1);
        }
        return result;
    }
}
