public class Solution1 {
    public double myPow(double x, int n) {
        Boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = (-1) * n;
        }
        return isNeg ? 1 / myPowSub(x, n) : myPowSub(x, n);
    }
    
    private double myPowSub(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        double half = myPowSub(x, n / 2);
        if (n % 2 == 0) return half * half;
        else return half * half * x;
    }
}
