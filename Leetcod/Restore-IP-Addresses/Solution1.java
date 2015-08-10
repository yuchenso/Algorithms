public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12) return result;
        List<String> current = new ArrayList<String>();
        resultBuilder(result, current, s, 0);
        return result;
    }
    
    private void resultBuilder(List<String> result, List<String> current, String s, int start) {
        if (start == s.length() && current.size() == 4) {
            StringBuilder item = new StringBuilder();
            item.append(current.get(0));
            for (int i = 1; i < current.size(); i++) {
                item.append("." + current.get(i));
            }
            result.add(item.toString());
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (!isValid(s.substring(start, end + 1))) {
                break;
            }
            else{
                current.add(s.substring(start, end + 1));
                resultBuilder(result, current, s, end + 1);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        int num = Integer.valueOf(s);
        if (s.length() > 3 || num > 255) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        return true;
    }
}
