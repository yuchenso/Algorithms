public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        int i = 0, j = 0;
        for (; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                if (map.size() == 2) {
                    result = Math.max(result, j - i);
                    while (map.size() == 2) {
                        char ci = s.charAt(i);
                        if (map.get(ci) == 1) map.remove(ci);
                        else map.put(ci, map.get(ci) - 1);
                        i++;
                    }
                }
                map.put(c, 1);
            }
        }
        result = Math.max(result, j - i);
        return result;
    }
}
