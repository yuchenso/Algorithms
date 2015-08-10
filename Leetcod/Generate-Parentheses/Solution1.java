public class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder current = new StringBuilder();
        resultBuilder(result, current, n, n);
        return result;
    }
    
    private void resultBuilder(List<String> result, StringBuilder current, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(current.toString());
            return;
        }
        
        if (left != 0) {
            current.append('(');
            resultBuilder(result, current, left - 1, right);
            current.deleteCharAt(current.length() - 1);
        }
        if (left != right) {
            current.append(')');
            resultBuilder(result, current, left, right - 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
