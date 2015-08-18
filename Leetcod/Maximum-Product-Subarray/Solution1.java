public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int rst = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            int tmpMin = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = tmpMax;
            min = tmpMin;
            rst = Math.max(rst, max);
        }
        return rst;
    }
}
