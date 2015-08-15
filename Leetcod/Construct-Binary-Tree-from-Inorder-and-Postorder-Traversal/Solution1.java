public class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i;
        for(i = inStart; i <= inEnd; i++) {
            if(inorder[i] == postorder[postEnd]) break;
        }
        root.left = buildTree(inorder, inStart, i - 1, postorder, postStart, postStart + i - 1 - inStart);
        root.right = buildTree(inorder, i + 1, inEnd, postorder, postStart + i - inStart, postEnd - 1);
        return root;
    }
}
