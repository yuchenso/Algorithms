/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution1 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        while(p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p, newNode);
            p = p.next;
        }
        Iterator<Map.Entry<RandomListNode, RandomListNode>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<RandomListNode, RandomListNode> item = iter.next();
            RandomListNode key = item.getKey();
            RandomListNode value = item.getValue();
            value.next = map.get(key.next);
            value.random = map.get(key.random);
        }
        return map.get(head);
    }
}
