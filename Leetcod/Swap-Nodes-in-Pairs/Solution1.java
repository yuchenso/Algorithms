public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode node3 = p.next.next.next;
            p.next = node2;
            node2.next = node1;
            node1.next = node3;
            p = p.next.next;
        }
        return dummy.next;
    }
}
