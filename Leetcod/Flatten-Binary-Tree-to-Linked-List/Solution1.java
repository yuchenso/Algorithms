public class Solution1 {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null) {
            prev = root;
            flatten(root.right);
        }
        else{
            flatten(root.left);
            prev.right = root.right;
            root.right = root.left;
            root.left = null;
            flatten(prev.right);
        }
    }
}
