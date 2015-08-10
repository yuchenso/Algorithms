public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 2) return nums.length;
        
        int valid = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[valid - 2] != nums[i]) {
                nums[valid++] = nums[i];
            }
        }
        
        return valid;
    }
}
