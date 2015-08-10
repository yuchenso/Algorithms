public class Solution1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode start = dummyHead, end = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            start = start.next;
        }
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        ListNode tmpEndNext = end.next;
        end.next = null;
        ListNode tmpEnd = start.next;
        ListNode tmpHead = reverse(start.next);
        start.next = tmpHead;
        tmpEnd.next = tmpEndNext;
        return dummyHead.next;
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
