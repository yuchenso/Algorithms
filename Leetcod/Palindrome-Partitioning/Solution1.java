public class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] matrix = buildMatrix(s);
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> current = new ArrayList<String>();
        resultBuilder(result, current, matrix, s, 0);
        return result;
    }
    
    private void resultBuilder(List<List<String>> result, List<String> current, boolean[][] matrix, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (matrix[end][start]) {
                current.add(s.substring(start, end + 1));
                resultBuilder(result, current, matrix, s, end + 1);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean[][] buildMatrix(String s) {
        int n = s.length();
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = true;
        }
        for (int i = 0, j = 1; j < n; i++, j++) {
            matrix[j][i] = s.charAt(i) == s.charAt(j);
        }
        for (int jStart = 2; jStart < n; jStart++) {
            for (int i = 0, j = jStart; j < n; i++, j++) {
                matrix[j][i] = s.charAt(i) == s.charAt(j) && matrix[j - 1][i + 1];
            }
        }
        return matrix;
    }
}
