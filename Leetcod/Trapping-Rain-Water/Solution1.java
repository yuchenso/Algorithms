public class Solution1 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int[] leftMaxArray = new int[height.length];
        int leftMax = 0;
        for (int i = 0; i < leftMaxArray.length; i++) {
            leftMaxArray[i] = leftMax;
            leftMax = Math.max(height[i], leftMax);
        }
        
        int[] rightMaxArray = new int[height.length];
        int rightMax = 0;
        for (int i = rightMaxArray.length - 1; i >= 0; i--) {
            rightMaxArray[i] = rightMax;
            rightMax = Math.max(height[i], rightMax);
        }
        
        int rst = 0;
        for (int i = 0; i < height.length; i++) {
            rst += Math.max(Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i], 0);
        }
        return rst;
    }
}
