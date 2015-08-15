public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        return validDepth(root) != -1;
    }
    
    int validDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = validDepth(root.left);
        if(leftDepth == -1) return -1;
        int rightDepth = validDepth(root.right);
        if(rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) <= 1? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}
