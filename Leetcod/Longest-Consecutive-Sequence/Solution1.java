public class Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length; 
        Set<Integer> set = new HashSet<Integer>();
    	for(int i = 0; i < nums.length; i++){
    		set.add(nums[i]);
    	}
        List<Integer> noDupNums = new ArrayList<Integer>(set);
        int rst = 1;
        for (int i = 0; i < noDupNums.size(); i++) {
            int pre = noDupNums.get(i) - 1;
            int pos = noDupNums.get(i) + 1;
            while (set.contains(pre)) {
                set.remove(pre);
                pre--;
            }
            while (set.contains(pos)) {
                set.remove(pos);
                pos++;
            }
            rst = Math.max(rst, pos - pre - 1);
        }
        return rst;
    }
}
