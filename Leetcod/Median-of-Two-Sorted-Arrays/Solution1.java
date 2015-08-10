public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (findKthElement(nums1, 0, nums2, 0, totalLength / 2) + findKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1)) / (double) 2;
        }
        else return findKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1);
    }
    
    private int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 == nums1.length) return nums2[start2 + k - 1];
        if (start2 == nums2.length) return nums1[start1 + k - 1];
        
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int halfK = k / 2;
        int value1 = start1 + halfK - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[start1 + halfK - 1];
        int value2 = start2 + halfK - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[start2 + halfK - 1];
        if (value1 < value2) {
            return findKthElement(nums1, start1 + halfK, nums2, start2, k - halfK);
        }
        else {
            return findKthElement(nums1, start1, nums2, start2 + halfK, k - halfK);
        }
    }
}
