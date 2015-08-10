public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> elements = new ArrayList<Integer>();
        if(matrix.length == 0) return elements;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = -1;
        while(true){
            for(int i = 0; i < n; i++){
                elements.add(matrix[row][++col]);
            }
            if(--m == 0) break;
            for(int i = 0; i < m; i++){
                elements.add(matrix[++row][col]);
            }
            if(--n == 0) break;
            for(int i = 0; i < n; i++){
                elements.add(matrix[row][--col]);
            }
            if(--m == 0) break;
            for(int i = 0; i < m; i++){
                elements.add(matrix[--row][col]);
            }
            if(--n == 0) break;            
        }
        return elements;
    }
}
