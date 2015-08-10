public class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> resultLeft = generateTrees(start, i - 1);
            List<TreeNode> resultRight = generateTrees(i + 1, end);
            for(int iLeft = 0; iLeft < resultLeft.size(); iLeft++){
                for(int iRight = 0; iRight < resultRight.size(); iRight++){
                    TreeNode root = new TreeNode(i);
                    root.left = resultLeft.get(iLeft);
                    root.right = resultRight.get(iRight);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
