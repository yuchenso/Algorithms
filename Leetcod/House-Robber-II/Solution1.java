public class Solution {
    public static int rob(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0]; 
    	int[] nums1 = new int[nums.length - 1];
    	System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
    	int[] nums2 = new int[nums.length - 1];
    	System.arraycopy(nums, 1, nums2, 0, nums.length - 1);
    	
    	return Math.max(subRob(nums1), subRob(nums2));
    }
    
    private static int subRob(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int[] array = new int[nums.length];
        array[0] = nums[0];
        if (nums.length > 1) array[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            array[i] = Math.max(array[i - 1], array[i - 2] + nums[i]);
        }
        return array[nums.length - 1];
    }
}
