public class SolutionDP {
    public int maxSubArray(int[] A) {
        int maxEndHere = A[0], maxSoFar = A[0];
        for(int i = 1; i < A.length; i++){
            maxEndHere = Math.max(maxEndHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
}
