public class Solution1 {
    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        boolean isNum = false;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        while (i < n && Character.isDigit(s.charAt(i))) {
            isNum = true;
            i++;
        }
        if (i < n && s.charAt(i) == '.') i++;
        while (i < n && Character.isDigit(s.charAt(i))) {
            isNum = true;
            i++;
        } 
        if (i < n && s.charAt(i) == 'e') {
            if (!isNum) return false;
            isNum = false;
            i++;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            isNum = true;
            i++;
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNum && i == n;
    }
}
