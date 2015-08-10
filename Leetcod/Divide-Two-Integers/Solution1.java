public class Solution1 {
    public int divide(int dividend, int divisor) {
        long dividendL = (long) dividend;
        long divisorL = (long) divisor;
        Boolean isNeg = dividendL < 0 && divisorL > 0 || dividendL > 0 && divisorL < 0;
        dividendL = Math.abs(dividendL);
        divisorL = Math.abs(divisorL);
        
        if (divisorL == 0) return Integer.MAX_VALUE;
        if (dividendL < divisorL) return 0;
        long rst = 0;
        while (dividendL >= divisorL) {
            long numDivisor = 1;
            long curDivisorSum = divisorL;
            while (curDivisorSum + curDivisorSum <= dividendL) {
                numDivisor += numDivisor;
                curDivisorSum += curDivisorSum;
            }
            rst += numDivisor;
            dividendL -= curDivisorSum;
        }
        rst = isNeg? (-1) * rst : rst;
        return rst > Integer.MAX_VALUE || rst < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) rst;
    }
}
