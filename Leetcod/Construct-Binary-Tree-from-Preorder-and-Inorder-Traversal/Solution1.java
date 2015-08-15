public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i;
        for(i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) break;
        }
        root.left = buildTree(preorder, preStart + 1, i - inStart + preStart, inorder, inStart, i - 1);
        root.right = buildTree(preorder, i - inStart + preStart + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }
}
