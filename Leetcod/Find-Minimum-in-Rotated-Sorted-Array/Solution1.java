public class Solution {
    public int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(num[start] < num[mid]) {
                if(num[start] < num[end]) return num[start];
                else start = mid;
            }
            else{
                end = mid;
            }
        }
        return Math.min(num[start], num[end]);
    }
}
