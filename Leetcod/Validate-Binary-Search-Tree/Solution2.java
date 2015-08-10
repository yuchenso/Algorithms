public class Solution2 {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left) || prev != null && prev.val >= root.val) return false;
        prev = root;
        return isValidBST(root.right);
    }
}
