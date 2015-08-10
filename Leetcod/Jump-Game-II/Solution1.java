public class Solution1 {
    public int jump(int[] nums) {
        int step = 0, validPositionThisLevel = 0, validPositionNextLevel = 0;
        for (int i = 0; i < nums.length; i++) {
            for(; i <= validPositionThisLevel; i++){
                if(i == nums.length - 1) return step;
                validPositionNextLevel = Math.max(validPositionNextLevel, i + nums[i]);
            }
            i--; // pay attention here.
            step++;
            validPositionThisLevel = validPositionNextLevel;
        }
        return Integer.MAX_VALUE; // cannot reach here.
    }
}
