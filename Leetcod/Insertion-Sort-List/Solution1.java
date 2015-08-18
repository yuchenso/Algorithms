/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        while(head != null) {
            ListNode pointer = dummyHead;
            while(true) {
                if(pointer.next == null || pointer.next.val > head.val) {
                    ListNode tmp = head.next;
                    head.next = pointer.next;
                    pointer.next = head;
                    head = tmp;
                    break;
                }
                pointer = pointer.next;
            }
        }
        return dummyHead.next;
    }
}
