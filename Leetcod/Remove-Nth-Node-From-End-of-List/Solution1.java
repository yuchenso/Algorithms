public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = dummyHead;
        for(int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while(cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
