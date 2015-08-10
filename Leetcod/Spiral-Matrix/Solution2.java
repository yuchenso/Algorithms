public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return rst;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int dir = 0; // 0: left -> right; 1: top -> bottom; 2: right -> left; 3: bottom -> top
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) rst.add(matrix[top][i]);
                top++;
            }
            if (dir == 1) {
                for (int j = top; j <= bottom; j++) rst.add(matrix[j][right]);
                right--;
            }
            if (dir == 2) {
                for (int i = right; i >= left; i--) rst.add(matrix[bottom][i]);
                bottom--;
            }
            if (dir == 3) {
                for (int j = bottom; j >= top; j--) rst.add(matrix[j][left]);
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return rst;
    }
}
