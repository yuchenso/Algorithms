public class Solution1 {
    public String countAndSay(int n) {
        String rst = "1";
        for (int i = 1; i < n; i++) {
            rst = nextNum(rst);
        }
        return rst;
    }
    
    private String nextNum(String str) {
        StringBuilder rst = new StringBuilder();
        Character c = str.charAt(0);
        int num = 1;
        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                num++;
            } 
            else {
                rst.append("" + num + c);
                c = str.charAt(i);
                num = 1;
            }
        }
        rst.append("" + num + c);
        return rst.toString();
    }
}
