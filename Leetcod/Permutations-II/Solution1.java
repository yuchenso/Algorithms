public class Solution1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        
        Arrays.sort(nums);
    	List<Integer> numList = new ArrayList<Integer>();
    	for(int i = 0; i < nums.length; i++){
    		numList.add(nums[i]);
    	}
    	
    	resultBuilder(result, current, numList, numList.size());
    	return result;
    }
    
    private void resultBuilder(List<List<Integer>> result, List<Integer> current, List<Integer> numList, int numLength) {
        if (current.size() == numLength) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = 0; i < numList.size(); i++) {
            if (i != 0 && numList.get(i) == numList.get(i - 1)) continue;
            
            int tmp = numList.get(i);
            current.add(tmp);
            numList.remove(i);
            resultBuilder(result, current, numList, numLength);
            numList.add(i, tmp);
            current.remove(current.size() - 1);
        }
    }
}
