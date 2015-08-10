public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int mid;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(target >= matrix[mid][0]){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(target >= matrix[end][0]) return searchArray(matrix[end], target);
        if(target >= matrix[start][0]) return searchArray(matrix[start], target);
        return false;
    }
    
    private boolean searchArray(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(target > array[mid]){
                start = mid;
            }
            else if (target < array[mid]){
                end = mid;
            }
            else{
                return true;
            }
        }
        if(target == array[start] || target == array[end]) return true;
        return false;
    }
}
