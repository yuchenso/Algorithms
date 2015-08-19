public class Solution {
    public static int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int bucketLength = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int numOfBuckets = (max - min) / bucketLength + 1;
        int[][] buckets = new int[numOfBuckets][3];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
            buckets[i][2] = 0;
        }
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketLength;
            buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num);
            buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num);
            buckets[bucketIndex][2] = 1;
        }
        int maxGap = Integer.MIN_VALUE;
        int prevMax = buckets[0][1];
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i][2] == 1) {
                maxGap = Math.max(maxGap, buckets[i][0] - prevMax);
                prevMax = buckets[i][1];
            }
        }
        return maxGap;
    }
}
