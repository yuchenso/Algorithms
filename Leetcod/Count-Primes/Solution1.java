public class Solution {
    public static int countPrimes(int n) {
        int N = n - 1;
        
        if (N <= 1) return 0;
        int rst = 0;
        boolean[] array = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (!array[i]) {
                rst++;
                for (int j = 2; i * j <= N; j++) {
                    array[i * j] = true;
                }
            }
        }
        
        return rst;
   }
}
