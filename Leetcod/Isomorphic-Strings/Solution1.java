public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> mapTO = new HashMap<Character, Character>();
        Map<Character, Character> mapFROM = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (mapTO.containsKey(s.charAt(i))) {
                if(mapTO.get(s.charAt(i)) != t.charAt(i)) return false;
            } 
            else if (mapFROM.containsKey(t.charAt(i))) {
                if(mapFROM.get(t.charAt(i)) != s.charAt(i)) return false;
            }
            else {
                mapTO.put(s.charAt(i), t.charAt(i));
                mapFROM.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
