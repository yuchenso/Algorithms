public class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        resultBuilder(result, current, nums, 0);
        return result;
    }
    
    private void resultBuilder (List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<Integer>(current));
        
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            
            current.add(nums[i]);
            resultBuilder(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
