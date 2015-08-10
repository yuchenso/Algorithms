public class Solution1 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == nums[start]) start++;
            else if (nums[mid] == nums[end]) end--;
            else if (nums[mid] > nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        
        if (nums[start] == target || nums[end] == target) return true;
        return false;
    }
}
