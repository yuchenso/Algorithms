public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head; 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null && node.next.next != null) {
            if (node.next.val != node.next.next.val) node = node.next;
            else {
                ListNode p = node.next;
                while (p.next != null && p.val == p.next.val) p = p.next;
                node.next = p.next;
            }
        }
        return dummy.next;
    }
}
