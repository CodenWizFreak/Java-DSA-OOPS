//leetcode problem 112

class Solution {
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.val==targetSum && root.left==null && root.right==null)
            return true;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);    
        
    }
}
