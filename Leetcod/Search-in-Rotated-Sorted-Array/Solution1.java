public class Solution1 {
    public int search(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(A[start] < A[mid]) {
                if(target >= A[start] && target <= A[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {
                if(target >= A[mid] && target <= A[end]){
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        if(target == A[start]) return start;
        if(target == A[end]) return end;
        return -1;
    }
}
