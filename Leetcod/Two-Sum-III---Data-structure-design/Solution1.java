public class TwoSum {
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
	public void add(int number) {
	    map.put(number, map.containsKey(number)? map.get(number) + 1 : 1);
	}

	public boolean find(int value) {
	    Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
	    while (iter.hasNext()) {
	        Map.Entry<Integer, Integer> item = iter.next();
	        int num1 = item.getKey();
	        int num2 = value - num1;
	        if (num1 == num2) {
	            if (item.getValue() > 1) return true;
	        }
	        else if (map.containsKey(num2)) {
	            return true;
	        }
	    }
	    return false;
	}
}
