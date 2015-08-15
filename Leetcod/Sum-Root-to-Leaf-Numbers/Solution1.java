public class Solution1 {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int pre){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return pre * 10 + root.val;
        int sum = pre * 10 + root.val;
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }
}
