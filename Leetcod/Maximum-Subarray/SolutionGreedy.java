public class SolutionCleanGreedy {
    public int maxSubArray(int[] A) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            result = Math.max(result, sum);
            sum = Math.max(sum, 0);
        }
        return result;
    }
}
