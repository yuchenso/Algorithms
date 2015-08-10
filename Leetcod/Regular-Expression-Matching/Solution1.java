public class Solution1 {
    public boolean isMatch(String s, String p) {
        int lengthS = s.length(), lengthP = p.length();
        boolean[][] matrix = new boolean[lengthP + 1][lengthS + 1];
        
        // base cases
        matrix[0][0] = true;
        for (int i = 1; i <= lengthS; i++) {
            matrix[0][i] = false;
        } 
        for (int j = 1; j <= lengthP; j++) {
            if (p.charAt(j - 1) == '*') {
                matrix[j][0] = matrix[j - 2][0];
            }
        }
        
        // other cases
        for (int j = 1; j <= lengthP; j++) {
            for (int i = 1; i <= lengthS; i++) {
                if (p.charAt(j - 1) != '*') {
                    matrix[j][i] = match(s.charAt(i - 1), p.charAt(j - 1)) && matrix[j - 1][i - 1];
                }
                else{
                    if (!match(s.charAt(i - 1), p.charAt(j - 2))) {
                        matrix[j][i] = matrix[j - 2][i];
                    }
                    else {
                        boolean rst = matrix[j - 2][i];
                        int numToMatch = 1;
                        while (rst == false && (i - numToMatch >= 0) && match(s.charAt(i - numToMatch), p.charAt(j - 2))) {
                            rst = matrix[j - 2][i - numToMatch];
                            numToMatch++;
                        }
                        matrix[j][i] = rst;
                    }
                }
            }
        }
        
        return matrix[lengthP][lengthS];
    }
    
    private boolean match(char s, char p) {
        if (p == '.') return true;
        return s == p;
    }
}
