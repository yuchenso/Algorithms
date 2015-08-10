public class Solution1 {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        int index = 0;
        int isNeg = 1;
        if(str.charAt(0) == '-'){
            index++;
            isNeg = -1;
        } 
        if(str.charAt(0) == '+'){
            index++;
        }
        
        long result = 0;
        for(; index < str.length(); index++){
            if(str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                result = result * 10 + str.charAt(index) - '0';
                if(result > Integer.MAX_VALUE) break;
            }
            else break;
        }
        
        if(result * isNeg > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result * isNeg < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result * isNeg;
    }
}
