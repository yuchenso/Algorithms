public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (sLength < tLength) return isOneEditDistance(t, s);
        int dif = sLength - tLength;
        if (dif > 1) return false;
        boolean onEdit = false;
        if (dif == 0) {
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (onEdit) return false;
                    onEdit = true;
                }
            }
            return onEdit;
        }
        else {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (onEdit) return false;
                    onEdit = true;
                    i++;
                    continue;
                }
                i++;
                j++;
            }
            return onEdit && i == j + 1 || !onEdit && i == j;
        }
    }
}
