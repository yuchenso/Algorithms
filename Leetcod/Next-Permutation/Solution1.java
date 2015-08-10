public class Solution1 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                // find the index where nums[index] is the smallest value that is bigger than nums[i - 1] from i to the end.
                int minIndex = Integer.MAX_VALUE;  
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1] && (minIndex == Integer.MAX_VALUE || nums[j] < nums[minIndex])) {
                        minIndex = j;
                    }
                }
                swap(nums, minIndex, i - 1);
                Arrays.sort(nums, i, nums.length);
                return;
            } 
        }
        reverse(nums);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;   
            i++;
            j--;
        }
    }
}
