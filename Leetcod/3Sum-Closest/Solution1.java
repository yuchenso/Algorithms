public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int rst = nums[0] + nums[1] + nums[2]; 
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                rst = Math.abs(target - sum) > Math.abs(target - rst) ? rst : sum;
                if (rst == target) return rst; 
                if (sum < target) {
                    start++;
                }
                else if (sum > target){
                    end--;
                }
            }
        }
        return rst;
    }
}
