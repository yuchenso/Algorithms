public class Solution1 {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < A.length; j++) {
            if(A[j] !=  A[i]) {
                A[i + 1] = A[j];
                i++;
            }
        }
        return i + 1;
    }
}
