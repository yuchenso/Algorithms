public class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        resultBuilder(result, current, numList);
        return result;
    }
    
    private void resultBuilder(List<List<Integer>> result, List<Integer> current, List<Integer> numList) {
        if (numList.size() == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = 0; i < numList.size(); i++) {
    		int tmp = numList.get(i);
    		current.add(tmp);
    		numList.remove(i);
    		resultBuilder(result, current, numList);
    		numList.add(i, tmp);
    		current.remove(current.size() - 1);
        }
    }
}
