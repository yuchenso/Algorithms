/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution1 {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        buildMap(node);
        Iterator<Map.Entry<UndirectedGraphNode, UndirectedGraphNode>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<UndirectedGraphNode, UndirectedGraphNode> item = iter.next();
            UndirectedGraphNode key = item.getKey();
            UndirectedGraphNode value = item.getValue();
            List<UndirectedGraphNode> newNeighbors = new ArrayList<UndirectedGraphNode>();
            for(UndirectedGraphNode itemInNeighbers : key.neighbors) {
                newNeighbors.add(map.get(itemInNeighbers));
            }
            value.neighbors = newNeighbors;
        }
        return map.get(node);
    }
    
    private void buildMap(UndirectedGraphNode node) {
        if(map.containsKey(node)) return;
        map.put(node, new UndirectedGraphNode(node.label));
        for(UndirectedGraphNode item : node.neighbors) {
            buildMap(item);
        }
    }
}
