public class Solution1 {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size() == 0) return null;
        return mergeKLists(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeKLists(List<ListNode> lists, int begin, int end) {
        if(begin == end) return lists.get(begin);
        ListNode head1 = mergeKLists(lists, begin, begin / 2 + end / 2);
        ListNode head2 = mergeKLists(lists, begin / 2 + end / 2 + 1, end);
        return mergeTwoLists(head1, head2);
    }
    
    private ListNode mergeTwoLists(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                p.next = head1;
                head1 = head1.next;
            }
            else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if(head1 != null) p.next = head1;
        if(head2 != null) p.next = head2;
        return dummyHead.next;
    }
}
