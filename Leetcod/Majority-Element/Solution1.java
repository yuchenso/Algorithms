public class Solution {
    public int majorityElement(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++) {
                count[j] += (num >> j) & 1;
            }
        }
        int result = 0;
        int half = nums.length / 2;
        for (int i = 31; i >= 0; i--) {
            result = result * 2 + (count[i] > half ? 1 : 0);
        }
        return result;
    }
}
