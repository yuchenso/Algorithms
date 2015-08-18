/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode item = stack.pop();
            result.add(item.val);
            if(item.left != null){
                stack.push(item.left);
            }
            if(item.right != null){
                stack.push(item.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
