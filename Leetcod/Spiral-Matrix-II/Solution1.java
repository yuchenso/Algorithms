public class SolutionClean1 {
    public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int dir = 0; // 0: left -> right; 1: top -> bottom; 2: right -> left; 3: bottom -> top;
        int count = 1;
        while (left <= right && top <= bottom) {
            if (dir == 0) {
                for (int i = left; i<= right; i++) rst[top][i] = count++;
                top++;
            }
            if (dir == 1) {
                for (int j = top; j <= bottom; j++) rst[j][right] = count++;
                right--;
            }
            if (dir == 2) {
                for (int i = right; i >= left; i--) rst[bottom][i] = count++;
                bottom--;
            }
            if (dir == 3) {
                for (int j = bottom; j >= top; j--) rst[j][left] = count++;
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return rst;
    }
}
