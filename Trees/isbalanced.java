class Solution {
    public boolean balanced(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(height(root.left)-height(root.right))<=1 && balanced(root.left) && balanced(root.right);   
    }
    public int height(TreeNode node)
    {
        if(node==null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
