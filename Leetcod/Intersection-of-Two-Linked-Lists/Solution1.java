/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        for(int i = 0; i < lengthA - lengthB; i++) headA = headA.next;
        for(int i = 0; i < lengthB - lengthA; i++) headB = headB.next;
        while(headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        for(; head.next != null; head = head.next, length++) {
        }
        return length;
    }
}
