public class Solution1 {
    public int mySqrt(int x) {
        long xl = x;
        long start = 0;
        long end = x;
        long mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid;
            }
            else if (mid * mid < x) {
                start = mid;
            }
            else return (int) mid;
        }
        if(end * end <= xl) return (int) end;
        return (int) start;
    }
}
