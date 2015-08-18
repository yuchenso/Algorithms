/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution1 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode medium = findMedium(head);
        ListNode right = reverse(medium.next);
        medium.next = null;
        head = merge(head, right);
    }
    
    private ListNode findMedium(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode one = head;
        ListNode two = head.next;
        
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode temp = null;
        
        while (head != null) {
            temp = head.next;
            head.next = res.next;
            res.next = head;
            head = temp;
        }
        return res.next;
    }
    
    private ListNode merge(ListNode headA, ListNode headB) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while (headA != null && headB != null) {
            tail.next = headA;
            tail = tail.next;
            headA = headA.next;
            tail.next = headB;
            tail = tail.next;
            
	        
            headB = headB.next;
        }
        if (headA != null) {
            tail.next = headA;
        }
        if (headB != null) {
            tail.next = headB;
        }
        return dummy.next;
    }
}

