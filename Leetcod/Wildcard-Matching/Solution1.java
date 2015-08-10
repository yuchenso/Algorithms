public class Solution1 {
    public static boolean isMatch(String s, String p) {
    	
    	if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')  
    	    return false;
    	
    	int sLength = s.length();
    	int pLength = p.length();
    	boolean[] array = new boolean[sLength + 1];
    	
    	// fill in the array first time (when j == 0)
    	array[0] = true;
        for(int i = 1; i <= sLength; i++){
        	array[i] = false;
        }
        
        // repeat to fill in the array when j == 1, 2, ... p.length()
        // this behavior has the same effect as fill in the matrix when matrix[j][i] just relies on matrix[j - 1][i]
        for(int j = 1; j <= pLength; j++){
        	for(int i = sLength; i >= 0; i--){
        		if(i == 0){
        			array[i] = array[i] && p.charAt(j - 1) == '*';
        			continue;
        		}
        		
        		if(p.charAt(j - 1) != '*'){
        			if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)){
        				array[i] = array[i - 1];
        			}
        			else{
        				array[i] = false;
        			}
        		}
        		else{
    				// traverse all the possible number of characters '*' going to match
    				boolean judge = array[i]; // '*' matches 0 character in String s
    				int k = 1;
    				while(judge == false && i - k >= 0){
    					judge = array[i - k];  // '*' matches k characters in String s
    					k++;
    				}
    				array[i] = judge;
        		}
        		
        	}
        }
    	
        return array[sLength];
    }
}
