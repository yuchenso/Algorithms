public class Solution1 {
    int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        helper(root);
        return maxPath;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int maxLeft = helper(root.left);
        int maxRight = helper(root.right);
        maxPath = Math.max(maxPath, maxLeft + maxRight + root.val);
        int singlePath = Math.max(maxLeft, maxRight) + root.val;
        return singlePath > 0 ? singlePath : 0;
    }
}
