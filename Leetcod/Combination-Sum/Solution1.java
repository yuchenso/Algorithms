public class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        resultBuilder(result, current, candidates, target, 0);
        return result;
    }
    
    private void resultBuilder(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        } 
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            
            current.add(candidates[i]);
            resultBuilder(result, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}
