public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; 
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[start]);
                    item.add(nums[end]);
                    result.add(item);
                    start++;
                    while(start < end && nums[start] == nums[start - 1]) start++;
                    end--;
                    while(start < end && nums[end] == nums[end + 1]) end--;
                }
                else if (sum < 0) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return result;
    }
}
