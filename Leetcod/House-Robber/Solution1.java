public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] array = new int[n + 1];
        if(n >= 1) array[1] = nums[0];
        if(n >= 2) array[2] = Math.max(nums[0], nums[1]);
        for(int i = 3; i <= n; i++) {
            array[i] = Math.max(array[i - 2], array[i - 3]) + nums[i - 1];
        }
        int rst = 0;
        for(int i = 1; i <= n; i++) {
            rst = Math.max(rst, array[i]);
        }
        return rst;
    }
}
