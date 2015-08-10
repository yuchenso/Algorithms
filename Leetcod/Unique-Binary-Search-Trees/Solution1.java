public class Solution1 {
    public int numTrees(int n) {
        if(n == 1) return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i - 1; j++){
                array[i] += array[j] * array[i - 1 - j];
            }
        }
        return array[n];
    }
}
