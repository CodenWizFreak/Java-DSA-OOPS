// Leetcode problem 637

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();

        if(root==null)
            return avg;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //insert root at the tail of the queue (which is empty currently)

        while(!queue.isEmpty())
        {
            int size = queue.size();
            double sum = 0.0;

            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll(); //removes element from the front of the queue and returns it
                sum+=node.val;

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);    
            }
            avg.add(sum/size);
        }  

        return avg;

        

        
    }
}
