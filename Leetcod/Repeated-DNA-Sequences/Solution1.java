public class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new ArrayList<String>();
    	
        int length = s.length();
        if(length <= 10){
        	return result;
        }
        
        // int[]: position 0: store the number of the same strings; 
        //        position 1: store the place of start position
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        
        for(int start = 0; start <= length - 10; start++){
        	int end = start + 9;
        	String str = s.substring(start, end + 1);
        	Integer strInteger = convertFromStringToInt(str);
        	if(map.containsKey(strInteger)){
        		int[] value = map.get(strInteger);
        		value[0] = value[0] + 1;
        		map.put(strInteger, value);
        	}
        	else{
        		int[] value = {1, start};
        		map.put(strInteger, value);
        	}
        }
        
        Iterator<Map.Entry<Integer, int[]>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
        	Map.Entry<Integer, int[]> itemEntry = iter.next();
        	int[] itemValue = itemEntry.getValue();
        	if(itemValue[0] > 1){
        		result.add(s.substring(itemValue[1], itemValue[1] + 10));
        	}
        }
        
        return result;
    }
    
    
    // use integer instead of string as the key of the map
    private static int convertFromStringToInt(String s){
    	int result = 0;
    	for(int i = 0; i < s.length(); i++){
    		result = result * 10 + getCode(s.charAt(i));
    	}
    	return result;
    }

    private static int getCode(char c){
    	if(c == 'A') return 1;
    	if(c == 'C') return 2;
    	if(c == 'G') return 3;
    	return 4;
    }
}
