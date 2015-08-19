public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (lower > upper) return result;
        int current = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < current) continue;
            else if (nums[i] == current) current = nums[i] + 1;
            else {
                if (nums[i] > upper) break;
                else {
                    result.add(generateRange(current, nums[i] - 1));
                    current = nums[i] + 1;
                    if (nums[i] == upper) break;
                }
            } 
        }
        if (upper >= current) result.add(generateRange(current, upper));
        return result;
    }
    
    private String generateRange(int lower, int upper) {
        if (lower == upper) return lower + "";
        else return lower + "->" + upper;
    }
}
