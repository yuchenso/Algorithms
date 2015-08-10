public class SolutionClean1 {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapT.put(c, mapT.containsKey(c)? mapT.get(c) + 1 : 1);
            mapS.put(c, 0);
        }
        
        int rst = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        
        int count = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!mapT.containsKey(c)) continue;
            mapS.put(c, mapS.get(c) + 1);
            if (mapS.get(c).intValue() == mapT.get(c).intValue()) { // pay attention here!
                count++;
                if (count == mapT.size()) {
                    for (; j <= i; j++) {
                        char c1 = s.charAt(j);
                        if (!mapT.containsKey(c1)) continue;
                        mapS.put(c1, mapS.get(c1) - 1);
                        if (mapS.get(c1) < mapT.get(c1)) {
                            count--;
                            if (rst > i - j + 1) {
                                rst = i - j + 1;
                                start = j;
                                end = i;
                            }
                            j++;
                            break;
                        }
                    }
                }
            }
        }
        
        return end == -1? "" : s.substring(start, end + 1);
    }
}
