public class Solution1 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] array = new boolean[n + 1];
        array[0] = true;
        for(int j = 1; j <= n; j++) {  // sIndex: j - 1
            for(int i = 0; i <= j - 1; i++) {  // sIndex: i
                if(wordDict.contains(s.substring(i, j)) && array[i]) {
                    array[j] = true;
                    break;
                }
            }
        }
        return array[n];
    }
}
