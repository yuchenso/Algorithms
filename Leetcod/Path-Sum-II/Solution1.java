public class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        resultBuilder(result, current, sum, root);
        return result;
    }
    
    private void resultBuilder(List<List<Integer>> result, List<Integer> current, int sum, TreeNode root){
        if(root == null) return;
        if(root.val == sum && root.left == null && root.right == null) {
            current.add(root.val);
            result.add(new ArrayList<Integer>(current));
            current.remove(current.size() - 1);
            return;
        }
        
        current.add(root.val);
        resultBuilder(result, current, sum - root.val, root.left);
        resultBuilder(result, current, sum - root.val, root.right);
        current.remove(current.size() - 1);
    }
}
