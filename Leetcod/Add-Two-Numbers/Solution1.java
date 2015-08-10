/**
 * 
 */
public class Solution {
    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        StringBuilder sb = new StringBuilder();
        int length = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < length; i++) {
            int ai = i < a.length()? a.charAt(i) - '0' : 0;
            int bi = i < b.length()? b.charAt(i) - '0' : 0;
            int sum = ai + bi + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(addBinary("100", "10"));
    }
}
