public class Solution1 {
    public TreeNode sortedArrayToBST(int[] num) {
        return helper(num, 0, num.length - 1);
    }
    
    private TreeNode helper(int[] num, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(num[start + (end - start) / 2]);
        root.left = helper(num, start, start + (end - start) / 2 - 1);
        root.right = helper(num, start + (end - start) / 2 + 1, end);
        return root;
    }
}
