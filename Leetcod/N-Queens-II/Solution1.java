public class Solution1 {
    public int totalNQueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        resultBuilder(result, current, n);
        return result.size();
    }
    
    private void resultBuilder(List<List<Integer>> result, List<Integer> current, int n) {
        if (current.size() == n) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(current, i, current.size())) {
                current.add(i);
                resultBuilder(result, current, n);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isValid(List<Integer> current, int i, int j) {
        for (int m = 0; m < current.size(); m++) {
            int n = current.get(m);
            if (n == i || j - m == Math.abs(i - n)) return false;
        }
        return true;
    }
}
