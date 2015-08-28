public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum >= s) {
                while (sum >= s) {
                    sum = sum - nums[start];
                    start++;
                }
                min = Math.min(min, end - start + 2);
            }
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }
}
