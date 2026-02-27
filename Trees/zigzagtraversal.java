// Leetcode problem 103

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        boolean leftToRight = true;

        while (!dq.isEmpty()) {
            int levelSize = dq.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) 
            {
                if (leftToRight) 
                {
                    TreeNode node = dq.pollFirst();
                    currentLevel.add(node.val);

                    if (node.left != null) 
                        dq.offerLast(node.left);
                    if (node.right != null) 
                        dq.offerLast(node.right);
                } 
                else 
                {
                    TreeNode node = dq.pollLast();
                    currentLevel.add(node.val);

                    // Important: reverse order
                    if (node.right != null) 
                        dq.offerFirst(node.right);
                    if (node.left != null) 
                        dq.offerFirst(node.left);
                }
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // toggle direction
        }

        return result;
    }
}
