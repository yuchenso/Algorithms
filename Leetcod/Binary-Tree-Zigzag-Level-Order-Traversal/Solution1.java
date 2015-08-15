public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> resultItem = new ArrayList<Integer>();
            int num = queue.size();
            for(int i = 0; i < num; i++){
                TreeNode item = queue.poll();
                resultItem.add(item.val);
                if(item.left != null){
                    queue.add(item.left);
                }
                if(item.right != null){
                    queue.add(item.right);
                }
            }
            if(result.size() % 2 == 1) Collections.reverse(resultItem);
            result.add(resultItem);
        }
        return result;  
    }
}
