public class Solution1 {
    
    TreeNode big = null;
    TreeNode small = null;
    TreeNode prev = null;
    
    private void inOrderTraveral(TreeNode root){
        if(root == null) return;
        inOrderTraveral(root.left);
        if(prev != null && root.val < prev.val) {
            if(big == null) big = prev;
            small = root;
        }
        prev = root;
        inOrderTraveral(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        inOrderTraveral(root);
        int tmp = this.big.val;
        this.big.val = this.small.val;
        this.small.val = tmp;    
    }
}
