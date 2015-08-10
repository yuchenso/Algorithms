public class Solution1 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int validZero = -1, index = 0, validTwo = nums.length;
        while (index < validTwo) {
            if (nums[index] == 0) {
                swap(nums, validZero + 1, index);
                validZero++;
                index++;
            } 
            else if (nums[index] == 1) {
                index++;
            }
            else {
                swap(nums, index, validTwo - 1);
                validTwo--;
            }
        }
    }
    
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
