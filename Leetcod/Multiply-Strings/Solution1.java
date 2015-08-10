public class Solution1 {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        int carry = 0;
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int sum = d[i] + carry;
            rst.append(sum % 10);
            carry = sum / 10;
        }
        rst.append(carry);
        rst = rst.reverse();
        while (rst.length() > 0 && rst.charAt(0) == '0') {
            rst.deleteCharAt(0);
        }
        return rst.length() == 0? "0" : rst.toString();
    }
}
