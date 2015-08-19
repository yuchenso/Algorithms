/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode leftNode = root.left;
        TreeNode newRoot = upsideDownBinaryTree(leftNode);
        leftNode.left = root.right;
        root.left = null;
        root.right = null;
        leftNode.right = root;
        return newRoot;
    }
}
