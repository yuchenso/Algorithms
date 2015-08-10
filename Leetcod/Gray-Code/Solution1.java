public class Solution1 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++) {
                result.add(i);
            }
            return result;
        }
        
        result = grayCode(n - 1);
        List<Integer> resultPos = reverse(result);
        int x = 1 << (n - 1);
        for (int i = 0; i < resultPos.size(); i++) {
            resultPos.set(i, resultPos.get(i) + x);
        }
        result.addAll(resultPos);
        return result;
    }
    
    private List<Integer> reverse(List<Integer> result) {
        List<Integer> resultPos = new ArrayList<Integer>();
        for (int i = result.size() - 1; i >= 0; i--) {
            resultPos.add(result.get(i));
        }
        return resultPos;
    }
}
