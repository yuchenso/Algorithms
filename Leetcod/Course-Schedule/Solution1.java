public class Solution {
    Map<Integer, Set<Integer>> income = new HashMap<Integer, Set<Integer>>();
    Map<Integer, Set<Integer>> output = new HashMap<Integer, Set<Integer>>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // initialize income map
        for (int i = 0; i < numCourses; i++) income.put(i, new HashSet<Integer>());
        // initialize output map
        for (int i = 0; i < numCourses; i++) output.put(i, new HashSet<Integer>());
        // fill in two maps
        for (int i = 0; i < prerequisites.length; i++) {
            income.get(prerequisites[i][0]).add(prerequisites[i][1]);
            output.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // store courses with 0 income into buffer
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        Iterator<Map.Entry<Integer, Set<Integer>>> iter = income.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Set<Integer>> item = iter.next();
            Integer key = item.getKey();
            Integer value = item.getValue().size();
            if (value == 0) {
                buffer.add(key);
            }
        }
        
        // Use BFS to detect cycle in graph
        Queue<Integer> bfsQueue = new LinkedList<Integer>();  
        for (int i = 0; i < buffer.size(); i++) {
            bfsQueue.add(buffer.get(i));
            income.remove(buffer.get(i));
        }
     
        while (!bfsQueue.isEmpty()) {
            if (income.size() == 0) return true; // if all the nodes don't have incoming edges, return true.
            int parent = bfsQueue.poll();
            Set<Integer> childrenLevel = output.get(parent);
            for (int child : childrenLevel) {
                Set<Integer> parentLevel = income.get(child);
                parentLevel.remove(parent);
                if (parentLevel.size() == 0) {
                    bfsQueue.add(child);
                    income.remove(child);
                }
            }
        }
        return false; // If there is cycles in graph, income will not be empty.
    }
}
