//Leetcode problem 684
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] union = new int[edges.length + 1];

        for(int i = 0; i <= edges.length; i++){
            union[i] = i;
        }
        
        
        for(int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            if(!union(nodeA, nodeB, union)){
                return edge;
            }
        }

        return new int[]{-1,-1};
    }

    private int find(int node, int[] union) {
        if(node == union[node]) return union[node];
        union[node] = find(union[node], union);
        return union[node];
    }

    private boolean union(int nodeA, int nodeB, int[] union){
        int rootA = find(nodeA, union);
        int rootB = find(nodeB, union);

        if (rootA == rootB) return false;

        union[rootA] = rootB;
        return true;
    }
}
