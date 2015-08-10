public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int tmp = nums[end];
                nums[end] = nums[i];
                nums[i] = tmp;
                end++;
            }
        }
        return end;
    }
}
