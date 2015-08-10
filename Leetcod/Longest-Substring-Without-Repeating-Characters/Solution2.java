public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int result = 0; int start = 0;
        for(int end = 0; end < s.length(); end++){
            while(exist[s.charAt(end)]){
                exist[s.charAt(start)] = false;
                start++;
            }
            result = Math.max(result, end - start + 1);
            exist[s.charAt(end)] = true;
        }
        return result;
    }
}
