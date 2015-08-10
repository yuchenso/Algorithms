public class Solution1 {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int maxArea = 0;
        // stack stores index of height whose value is in ascending order 
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && cur < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, w * h);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
