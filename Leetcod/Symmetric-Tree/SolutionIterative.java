public class SolutionIterative {
    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queueLeft = new LinkedList<TreeNode>();
        Queue<TreeNode> queueRight = new LinkedList<TreeNode>();
        queueLeft.offer(root.left);
        queueRight.offer(root.right);
        while(!queueLeft.isEmpty() && !queueRight.isEmpty()){
            TreeNode itemLeft = queueLeft.poll();
            TreeNode itemRight = queueRight.poll();
            if((itemLeft != null && itemRight == null) || (itemLeft == null && itemRight != null)) return false;
            if(itemLeft != null && itemRight != null) {
                if(itemLeft.val != itemRight.val) return false;
                queueLeft.offer(itemLeft.left);
                queueLeft.offer(itemLeft.right);
                queueRight.offer(itemRight.right);
                queueRight.offer(itemRight.left);
            }
        }
        return true;
    }
}
