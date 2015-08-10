/**
 * 1. Method 1, start from the first one, compare prefix with next string, until end;
 * 2. Method 2, start from the first char, compare it with all string, and then the second char
 * I am using method 1 here
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefix (prefix, strs[i]);
        }
        return prefix;
    }
    
    private String getPrefix(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return "";
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) break;
            i++;
        }
        return s1.substring(0, i);
    }
}
