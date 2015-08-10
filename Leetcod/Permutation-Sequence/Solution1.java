public class Solution1 {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder result = new StringBuilder();
        resultBuilder(result, nums, k);
        return result.toString();
    }
    
    private void resultBuilder(StringBuilder result, List<Integer> nums, int k) {
        if (nums.size() == 1) {
            result.append(nums.get(0));
            return;
        }
        int length = getFactorial(nums.size() - 1);
        int index = (int) Math.ceil((double)k / length) - 1;
        result.append(nums.get(index));
        nums.remove(index);
        resultBuilder(result, nums, k - index * length);
    }
    
    private int getFactorial(int n) {
        if (n == 1) return 1;
        return getFactorial(n - 1) * n;
    }
}
