public class Solution1 {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] array = new int[s.length() + 1];
        array[0] = 1;
        if (s.length() >= 1) array[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int val = 0;
            if (s.charAt(i - 1) != '0') val += array[i - 1];
            if (isValid(s.substring(i - 2, i))) val += array[i - 2];
            array[i] = val;
        }
        return array[s.length()];
    }
    
    private Boolean isValid(String s) {
        int a = Integer.valueOf(s);
        return a >= 10 && a <= 26;
    }
}
