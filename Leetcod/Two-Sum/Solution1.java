public class Solution {
	
    public int[] twoSum(int[] nums, int target) {
		int[] sortedNumbers = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortedNumbers);
		
		int[] indexValues = new int[2];
		int i = 0;
		int j = sortedNumbers.length - 1;
		while (true) {
			if ((sortedNumbers[i] + sortedNumbers[j]) > target) {
				j--;
			} else if ((sortedNumbers[i] + sortedNumbers[j]) < target) {
				i++;
			} else {
				indexValues[0] = sortedNumbers[i];
				indexValues[1] = sortedNumbers[j];
				break;
			}
		}

		int[] indices = new int[2];
		int returnIndex = 0;
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] == indexValues[0] || nums[k] == indexValues[1]) {
				indices[returnIndex] = k + 1;
				returnIndex++;
			}
			if (returnIndex == 2) {
				break;
			}
		}
		
		return indices;
    }
}
