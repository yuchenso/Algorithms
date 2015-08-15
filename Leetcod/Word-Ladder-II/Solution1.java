public class Solution1 {
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> resultList = new ArrayList<List<String>>();
    	Map<String, List<String>> backTrackingMap = new HashMap<String, List<String>>();
    	int level = ladderLength(start, end, dict, backTrackingMap);
    	if(level == 0) return resultList;
    	List<String> current = new ArrayList<String>();
    	current.add(start);
    	buildResult(resultList, current, end, level, backTrackingMap);
    	return resultList;
    }
    
    private static int ladderLength(String start, String end, Set<String> dict, Map<String, List<String>> backTrackingMap) {
        if(dict == null || dict.size() == 0 || !dict.contains(end)) return 0;
        Queue<String> bfsQueue = new LinkedList<String>();
        bfsQueue.add(start);
        dict.remove(start);
        int level = 0;
        while(!bfsQueue.isEmpty()){
        	int count = bfsQueue.size();
        	level++;
        	Set<String> bufferSet = new HashSet<String>();
        	for(int i = 0; i < count; i++){
	        	String item = bfsQueue.poll();
	        	if(item.equals(end)) return level;
	        	for(int j = 0; j < item.length(); j++){
	        		for(char c = 'a'; c <= 'z'; c++){
	        			String tmp = replace(item, j, c);
	        			if(dict.contains(tmp)){
	        				bufferSet.add(tmp);
        					if(backTrackingMap.containsKey(item)){
        						backTrackingMap.get(item).add(tmp);        						
        					}
        					else{
            					List<String> tmpList = new ArrayList<String>();
            					tmpList.add(tmp);
            					backTrackingMap.put(item, tmpList);
        					}
	        			}
	        		}
	        	}
        	}
        	Iterator<String> iter = bufferSet.iterator();
        	while(iter.hasNext()){
        		String iterItem = iter.next();
        		bfsQueue.add(iterItem);
        		dict.remove(iterItem);
        	}
        }
		return 0;
    }
    
    private static String replace(String item, int j, char c){
    	char[] chars = item.toCharArray();
    	chars[j] = c;
    	return new String(chars);
    }
    
    private static void buildResult(List<List<String>> resultList, List<String> current, String end, int level, Map<String, List<String>> backTrackingMap){
    	if(current.size() == level){
    		if(end.equals(current.get(current.size() - 1))){
	    		resultList.add(new ArrayList<String>(current));
    		}
    		return;
    	}
    	String lastEleString = current.get(current.size() - 1);
    	if (!backTrackingMap.containsKey(lastEleString)) return;
    	List<String> arrowList = backTrackingMap.get(lastEleString);
    	for(int i = 0; i < arrowList.size(); i++){
    		current.add(arrowList.get(i));
    		buildResult(resultList, current, end, level, backTrackingMap);
    		current.remove(current.size() - 1);
    	}
    }
}
