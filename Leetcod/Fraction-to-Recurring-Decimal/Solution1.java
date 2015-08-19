public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        Long numeratorL = (long) numerator;
        Long denominatorL = (long) denominator;
        
        boolean isNegative = numeratorL * denominatorL < 0;
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);
        
        StringBuilder result = new StringBuilder();
        long integ = numeratorL / denominatorL;
        long remainder = numeratorL % denominatorL;
        result.append(integ);
        if (remainder == 0) return isNegative? "-" + result.toString() : result.toString();
        result.append(".");
        Map<Long, Integer> repeatMap = new HashMap<Long, Integer>();
        while (remainder != 0 && !repeatMap.containsKey(remainder)) {
            int prevLength = result.length();
            repeatMap.put(remainder, prevLength);
            integ = remainder * 10 / denominatorL;
            remainder = remainder * 10 % denominatorL;
            result.append(integ);
        }
        if (remainder != 0) {
            result.insert(repeatMap.get(remainder), "(");
            result.append(")");
        }
        return isNegative? "-" + result.toString() : result.toString();
    }
}
