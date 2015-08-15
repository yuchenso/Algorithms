public class Solution1 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0 || !wordDict.contains(endWord)) {
            return 0;
        }
        
        int level = 0;
        Queue<String> bfsQueue = new LinkedList<String>();
        bfsQueue.add(beginWord);
        while (!bfsQueue.isEmpty()) {
            level++;
            int levelSize = bfsQueue.size();
            for (int i = 0; i < levelSize; i++) {
                String item = bfsQueue.poll();
                if (item.equals(endWord)) {
                    return level;
                }
                for (int j = 0; j < item.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newItem = setCharAt(item, j, c);
                        if (wordDict.contains(newItem)) {
                            bfsQueue.add(newItem);
                            wordDict.remove(newItem);
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    private String setCharAt(String s, int pos, char c) {
        char[] chars = s.toCharArray();
        chars[pos] = c;
        return new String(chars);
    }
}
