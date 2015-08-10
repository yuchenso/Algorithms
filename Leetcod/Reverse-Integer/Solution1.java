public class Solution {
    public int reverse(int x) {
        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
            // handle overflow/underflow
            if(Math.abs(result) > Integer.MAX_VALUE) return 0;
        }
        return (int) result;
    }
}
