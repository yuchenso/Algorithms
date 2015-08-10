public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 3) {
            return result;
        }
        
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first != 0 && nums[first] == nums[first - 1]) continue; // avoid duplicates
            
            for (int second = first + 1; second < nums.length; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1]) continue; // avoid duplicates
                
                int start = second + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[first] + nums[second] + nums[start] + nums[end];
                    if (sum > target) {
                        end--;
                    }
                    else if (sum < target) {
                        start++;
                    }
                    else{
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);
                        start++;
                        while (start < end && nums[start] == nums[start - 1]) start++; // avoid duplicates
                        end--;
                        while (end > start && nums[end] == nums[end + 1]) end--; // avoid duplicates
                    }
                }
            }
        }
        
        
        return result;
    }
}
