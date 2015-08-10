public class Solution1 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxArea = 0;
        int[] array = new int[matrix[0].length];
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < array.length; i++) {
                array[i] = matrix[j][i] == '0' ? 0 : array[i] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(array));
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int maxArea = 0;
        // stack stores index of height whose value is in ascending order 
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, w * h);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
