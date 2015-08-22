/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        if(root != null) {
            stack.push(root);
            while(stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode item = this.stack.pop();
        if(item.right != null){
            stack.push(item.right);
            while(stack.peek().left != null){
                stack.push(stack.peek().left);
            }
        }
        return item.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
