public class Solution1 {
    public int climbStairs(int n) {
        int p = 1, q = 1;
        for(int i = 2; i <= n; i++) {
            int tmp = p;
            p = q;
            q = q + tmp;
        }
        return q;
    }
}
