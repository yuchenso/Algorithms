public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare (ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) heap.add(lists[i]);
        }
        
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) heap.add(node.next);
        }
        return dummy.next;
    }
}
