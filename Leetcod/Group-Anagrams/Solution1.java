public class Solution1 {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0) return result;
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String originalString = strs[i];
            char[] charArray = originalString.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(originalString);
            }
            else {
                List<String> item = new ArrayList<String>();
                item.add(originalString);
                map.put(sortedString, item);
            }
        }
        
        Iterator<Map.Entry<String, List<String>>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, List<String>> item = iter.next();
            List<String> value = item.getValue();
            if (value.size() >= 2) {
                result.addAll(value);
            } 
        }
        
        return result;
    }
}
