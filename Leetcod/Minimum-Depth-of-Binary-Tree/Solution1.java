public class Solution1 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftMin = root.left == null? Integer.MAX_VALUE : minDepth(root.left);
        int rightMin = root.right == null? Integer.MAX_VALUE : minDepth(root.right);
        return Math.min(leftMin, rightMin) + 1;
    }
}
