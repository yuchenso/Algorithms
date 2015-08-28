public class Solution {
    Map<Integer, Set<Integer>> income = new HashMap<Integer, Set<Integer>>();
    Map<Integer, Set<Integer>> output = new HashMap<Integer, Set<Integer>>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) income.put(i, new HashSet<Integer>()); 
        for (int i = 0; i < numCourses; i++) output.put(i, new HashSet<Integer>()); 
        
        for (int i = 0; i < prerequisites.length; i++) {
            income.get(prerequisites[i][0]).add(prerequisites[i][1]);
            output.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        Iterator<Map.Entry<Integer, Set<Integer>>> iter = income.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<Integer, Set<Integer>> item = iter.next();
            if (item.getValue().size() == 0) buffer.add(item.getKey());
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        for (int i = 0; i < buffer.size(); i++) {
            bfsQueue.add(buffer.get(i));
            income.remove(buffer.get(i));
        }
        result.addAll(bfsQueue);
        
        while (!bfsQueue.isEmpty()) {
            if (income.size() == 0) return transferResult(result);
            int parent = bfsQueue.poll();
            Set<Integer> childrenLevel = output.get(parent);
            for (int child : childrenLevel) {
                Set<Integer> parentLevel = income.get(child);
                parentLevel.remove(parent);
                if (parentLevel.size() == 0) {
                    bfsQueue.add(child);
                    income.remove(child);
                    result.add(child);
                }
            }
        }
        return new int[0];
    }
    
    private int[] transferResult (ArrayList<Integer> result) {
        int[] rst = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            rst[i] = result.get(i);
        }
        return rst;
    }
}
