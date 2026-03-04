//Leetcode problem 124

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) { //O(n)
        helper(root);
        return ans;
    }
    int helper(TreeNode node){ //we're doing post-order traversal
        if(node==null)
            return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        left=Math.max(0,left);
        right=Math.max(0,right);

        int pathSum = left+right+node.val;    

        ans=Math.max(ans,pathSum);

        return Math.max(left,right)+node.val;
    }
}
