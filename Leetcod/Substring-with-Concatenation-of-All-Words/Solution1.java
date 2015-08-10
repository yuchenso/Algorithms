public class Solution1 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        // put all words into toFind map
        Map<String, Integer> toFind = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (toFind.containsKey(words[i])) {
                toFind.put(words[i], toFind.get(words[i]) + 1);
            }
            else {
                toFind.put(words[i], 1);
            }
        }
        
        int numWords = words.length, wordLength = words[0].length();
        for (int i = 0; i <= s.length() - numWords * wordLength; i++) {
            Map<String, Integer> found = new HashMap<String, Integer>();
            int j = 0;
            for (; j < numWords; j++) {
                int start = i + j * wordLength;
                String sub = s.substring(start, start + wordLength);
                if (!toFind.containsKey(sub)) break;
                if (found.containsKey(sub)) {
                    found.put(sub, found.get(sub) + 1);
                } 
                else {
                    found.put(sub, 1);
                }
                if (found.get(sub) > toFind.get(sub)) break; 
            }
            if (j == numWords) result.add(i); 
        }
        return result;
    }
}
