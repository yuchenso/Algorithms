public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        if (m + 1 == n) return m & n;
        return rangeBitwiseAnd(m >> 1, n >> 1) << 1;
    }
}
