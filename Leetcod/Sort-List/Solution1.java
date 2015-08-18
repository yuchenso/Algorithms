/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMidNode(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return mergeTwoSortedList(left, right);
    }
    
    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                node.next = head1;
                head1 = head1.next;
            }
            else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if(head1 != null) node.next = head1;
        else node.next = head2;
        return dummyHead.next;
    }
}
