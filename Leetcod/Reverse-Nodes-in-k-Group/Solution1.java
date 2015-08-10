public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = dummyHead;
        while(true) {
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }
            if(cur == null) break;
            ListNode tmpEndNext = cur.next;
            cur.next = null;
            ListNode tmpEnd = pre.next;
            ListNode tmpHead = reverse(pre.next);
            pre.next = tmpHead;
            tmpEnd.next = tmpEndNext;
            pre = tmpEnd;
            cur = tmpEnd;
        }
        return dummyHead.next;
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
