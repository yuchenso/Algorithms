public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int length = getLength(head);
        int newK = k % length;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = dummyHead;
        for(int i = 0; i < newK; i++) {
            cur = cur.next;
        }
        while(cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        cur.next = dummyHead.next;
        dummyHead.next = pre.next;
        pre.next = null;
        return dummyHead.next;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        for(; head != null; head = head.next, length++) {
        }
        return length;
    }
}
