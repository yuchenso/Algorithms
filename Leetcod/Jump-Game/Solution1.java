public class Solution1 {
    public boolean canJump(int[] nums) {
        int validPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > validPosition) return false;
            validPosition = Math.max(validPosition, i + nums[i]);
        }
        return true;
    }
}
