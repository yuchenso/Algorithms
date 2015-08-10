public class Solution1 {
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid;
        while(start + 1 < end){
            mid = (start + end) / 2;
            if(target > A[mid]) {
                start = mid;
            }
            else if(target < A[mid]) {
                end = mid;
            }
            else {
                end = mid;
            }
        }
        if(target <= A[start]) return start;
        if(target > A[end]) return end + 1;
        return end;
    }
}
