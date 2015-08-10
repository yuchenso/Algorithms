public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            int item1 = index1 == -1? Integer.MIN_VALUE : nums1[index1];
            int item2 = index2 == -1? Integer.MIN_VALUE : nums2[index2];
            if (item1 > item2) {
                nums1[i] = item1;
                index1--;
            }
            else {
                nums1[i] = item2;
                index2--;
            }
        }
    }
}
