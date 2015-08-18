public class Solution1 {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<String> rst = new ArrayList<String>();
        if (!buildBackTrackingArrows(s, wordDict, map)) return rst;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> current = new ArrayList<String>();
        buildResult(result, current, map, s, s.length());
        
        for (int i = 0; i < result.size(); i++) {
            List<String> item = result.get(i);
            StringBuilder one = new StringBuilder();
            for (int j = 0; j < item.size(); j++) {
                if (j == 0) one.append(item.get(j));
                else one.append(" " + item.get(j));
            }
            rst.add(one.toString());
        }
        return rst;
    }
    
    private static boolean buildBackTrackingArrows(String s, Set<String> wordDict, Map<Integer, List<Integer>> map) {
        int n = s.length();
        boolean[] array = new boolean[n + 1];
        array[0] = true;
        for (int j = 1; j <= n; j++) { // index j - 1
            for (int i = 0; i <= j - 1; i++) { // index i - 1
                if (array[i] && wordDict.contains(s.substring(i, j))) {
                    array[j] = true;
                    if (!map.containsKey(j)) {
                    	List<Integer> item = new ArrayList<Integer>();
                    	item.add(i);
                        map.put(j, item);
                    }
                    else {
                        map.get(j).add(i);
                    }
                }
            }
        }
        return array[n];
    }
    
    private static void buildResult(List<List<String>> result, List<String> current, Map<Integer, List<Integer>> map, String s, int end) {
        if (end == 0) {
            result.add(new ArrayList<String>(current));
            return;
        }
        
        List<Integer> nextLayer = map.get(end);
        for (int i = 0; i < nextLayer.size(); i++) {
            int start = nextLayer.get(i);
            current.add(0, s.substring(start, end));
            buildResult(result, current, map, s, start);
            current.remove(0);
        }
    }
}
