public class Solution1 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int rst = 0;
        
        while (left < right) {
            rst = Math.max(rst, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return rst;
    }
}
