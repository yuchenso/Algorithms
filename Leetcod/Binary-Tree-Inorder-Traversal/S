public class Solution1 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
        if(root == null){
        	return resultArrayList;
        }
        
    	ArrayList<Integer> resultArrayListLeft = inorderTraversal(root.left);
    	resultArrayList.addAll(resultArrayListLeft);
        
        resultArrayList.add(root.val);
        
    	ArrayList<Integer> resultArrayListRight = inorderTraversal(root.right);
    	resultArrayList.addAll(resultArrayListRight);

        return resultArrayList;
    }
}
