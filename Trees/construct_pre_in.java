//leetcode problem 105

class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = map.get(rootVal);
        
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);
        
        return root;
    }
}

// With hashmaps, O(n), without O(n^2)
