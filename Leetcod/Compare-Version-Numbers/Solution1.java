public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        
        int n = v1.length < v2.length? v1.length : v2.length;
        int i = 0;
        for (; i < n; i++) {
            int item1 = Integer.valueOf(v1[i]);
            int item2 = Integer.valueOf(v2[i]);
            if (item1 < item2) return -1;
            else if (item1 > item2) return 1;
        }
        for (; i < v1.length; i++) {
            if (Integer.valueOf(v1[i]) != 0) return 1;
        }
        for (; i < v2.length; i++) {
            if (Integer.valueOf(v2[i]) != 0) return -1;
        }
        return 0;
    }
}
