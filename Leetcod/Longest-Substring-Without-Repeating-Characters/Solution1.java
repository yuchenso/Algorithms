public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int start = 0, rst = 0;
        for (int end = 0; end < s.length(); end++) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                rst = Math.max(rst, end - start + 1);
            }
            else {
                for (; start <= end; start++) {
                    if (s.charAt(start) == s.charAt(end)) {
                        start++;
                        break;
                    }
                    if (set.contains(s.charAt(start))) set.remove(s.charAt(start));
                }
            }
        }
        return rst;
    }
}
