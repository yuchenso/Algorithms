public class Solution1 {
    public static List<String> fullJustify(String[] words, int L) {
        List<String> resultList = new ArrayList<String>();
        if(words == null || words.length == 0 || L == 0){
        	resultList.add("");
        	return resultList;
        }
        
        List<String> oneLineList = new ArrayList<String>();
        int currentLineLength = 0;
        for(int i = 0; i < words.length; i++){
        	
    		if(currentLineLength == L + 1){
    			String itemString = noAdjustBuild(oneLineList, L);
    			resultList.add(itemString);
    			
            	oneLineList = new ArrayList<String>();
            	currentLineLength = 0;
    		}
    		
        	String itemString = words[i];
        	if(currentLineLength + itemString.length() <= L){
        		oneLineList.add(itemString);
        		currentLineLength = currentLineLength + itemString.length() + 1;
        	}
        	else{
        		String item = normalAdjustBuild(oneLineList, L, currentLineLength);
        		resultList.add(item);
        		
            	oneLineList = new ArrayList<String>();
            	oneLineList.add(itemString);
            	currentLineLength = itemString.length() + 1;
        	}
        }
        
        // last line
        if(oneLineList.size() != 0){
        	String itemString = noAdjustBuild(oneLineList, L);
        	resultList.add(itemString);
        }
        
        return resultList;
    }
    
    private static String noAdjustBuild(List<String> oneLineList, int L){
		StringBuilder lineBuilder = new StringBuilder();
		for(int j = 0; j < oneLineList.size(); j++){
			if(j == oneLineList.size() - 1){
				lineBuilder.append(oneLineList.get(j));
			}
			else{
				lineBuilder.append(oneLineList.get(j) + " ");
			}
		}
		
		while(L > lineBuilder.length()){
			lineBuilder.append(" ");
		}
		
		return lineBuilder.toString();
    }
    
    private static String normalAdjustBuild(List<String> oneLineList, int L, int currentLineLength){
    	int itemNum = oneLineList.size();
    	if(itemNum == 1){
    		StringBuilder stepStringBuilder = new StringBuilder(oneLineList.get(0));
    		for(int i = 0; i < L - oneLineList.get(0).length(); i++){
    			stepStringBuilder.append(" ");
    		}
    		return stepStringBuilder.toString();
    	}
    	
    	int spaceNum = L - currentLineLength + itemNum;
    	int bottomSpaceNum = spaceNum / (itemNum - 1);
    	int numberOfCeilSpace = spaceNum % (itemNum - 1);
    	StringBuilder lineBuilder = new StringBuilder();
    	for(int j = 0; j < oneLineList.size(); j++){
			if(j == oneLineList.size() - 1){
				lineBuilder.append(oneLineList.get(j));
			}
			else{
				lineBuilder.append(oneLineList.get(j));
				for(int num = 0; num < bottomSpaceNum; num++){
					lineBuilder.append(" ");
				}
				if(j < numberOfCeilSpace){
					lineBuilder.append(" ");
				}
			}
    	}
    	return lineBuilder.toString();
    }   
}
