public class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        resultBuilder(result, current, n, k, 1);
        return result;
    }
    
    private void resultBuilder(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            resultBuilder(result, current, n, k - 1, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
