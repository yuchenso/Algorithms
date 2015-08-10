public class Solution1 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] array = new int[n + 1];
        array[0] = 0;
        if (n >= 1) array[1] = 0;
        for (int i = 2; i <= n; i++) { // sIndex: i - 1
            if(s.charAt(i - 1) == ')') {
                if(i - array[i - 1] - 2 >= 0 && s.charAt(i - array[i - 1] - 2) == '(') {
                    array[i] = array[i - 1] + 2 + array[i - array[i - 1] - 2];
                }
            }
        }
        
    	int max = 0;
    	for(int i = 1; i <= n; i++){
            max = Math.max(array[i], max);
    	}
    	return max;
        
    }
}
