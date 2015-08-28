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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            TreeNode last = null;
            for(int i = 0; i < num; i++) {
                TreeNode item = queue.poll();
                last = item;
                if(item.left != null) queue.offer(item.left);
                if(item.right != null) queue.offer(item.right);
            }
            result.add(last.val);
        }
        return result;
    }
}
