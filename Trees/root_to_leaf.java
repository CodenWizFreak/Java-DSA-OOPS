//leetcode problem 129
public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int current) {
        if (node == null) return 0;
        
        current = current * 10 + node.val;
        
        // leaf node
        if (node.left == null && node.right == null)
            return current;
        
        return dfs(node.left, current) + dfs(node.right, current);
    }
