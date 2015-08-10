public class Solution1 {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode leftDummy = new ListNode(0);
        ListNode leftNode = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightNode = rightDummy;
        while(head != null) {
            if(head.val < x) {
                leftNode.next = head;
                leftNode = leftNode.next;
            }
            else{
                rightNode.next = head;
                rightNode = rightNode.next;
            }
            head = head.next;
        }
        rightNode.next = null;
        leftNode.next = rightDummy.next;
        return leftDummy.next;
    }
}
