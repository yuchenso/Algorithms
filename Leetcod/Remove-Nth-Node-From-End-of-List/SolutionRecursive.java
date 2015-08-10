public class SolutionRecursive {
    class ResultType {
		ListNode node;
		int index;
		public ResultType (ListNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}
	
	public ListNode kthToLast (ListNode head, int k) {
		ResultType result = new ResultType(null, 0);
		helper(head, k, result);
		return result.node;
	}
	
	public void helper (ListNode head, int k, ResultType result) {
		if (head == null) return;
		helper(head.next, k, result); // head.next until head == null
		result.index++; // Then index++ until index == k
		if (result.index == k) {
			result.node = head;
		}
	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = kthToLast (dummyHead, n + 1);
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
