public class Solution1 {
    ListNode prev;
    public TreeNode sortedListToBST(ListNode head) {
        prev = head;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return helper(0, len - 1);
    }
    
    private TreeNode helper(int start, int end){
        if(start > end) return null;
        TreeNode left = helper(start, (start + end) / 2 - 1);
        TreeNode root = new TreeNode(prev.val);
        root.left = left;
        prev = prev.next;
        root.right = helper((start + end) / 2 + 1, end);
        return root;
    }
}
